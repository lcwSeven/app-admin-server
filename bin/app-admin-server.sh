#!/usr/bin/env bash
bin=`dirname "$0"`
APP_HOME=`cd "$bin"/..; pwd`
PG_NAME=default-main-name.jar
JAVA_OPTS='-server -Xms4096m -Xmx4096m -XX:+HeapDumpOnOutOfMemoryError'
#输出环境变量
echo \$ENV_ACTIVE=${ENV_ACTIVE}
echo \$JAVA_OPTS=$JAVA_OPTS

#判断环境变量是否为空
if [ -z "${ENV_ACTIVE}" ];then
    echo "ERROR:ENV_ACTIVE is not set,must be dev,test or prod."
    exit 1
fi
#使用
function print_usage(){
    echo " "
    echo "Usage:$PRG_NAME COMMAND"
    echo "     where COMMAND is one of:"
    echo "start         start $PRG_NAME"
    echo "stop          stop $PRG_NAME"
    echo "status        show status of $PRG_NAME"
    echo ""
}

if [ $# = 0 ];then
    print_usage
    exit
fi

CLASSPATH="$APP_HOME"/conf/
#auto find the exxcutable jar with version
for jar in "$APP_HOME"/*.jar
do
    PRG_NAME=${jar}
    echo \$PRG_NAME=${jar}
done

if [ "$JAVA_HOME" != "" ];then
    # echo "run java in $JAVA_HOME"
    JAVA_HOME=$JAVA_HOME
else
    JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")
fi

if [ "$JAVA_HOME" = "" ];then
    echo "Error:JAVA_HOME is not set."
    exit 1
fi

echo \$JAVA_HOME=$JAVA_HOME

for jar in "$APP_HOME"/*.jar
    do CLASSPATH=${CLASSPATH}:${jar}
done

for jar in "$APP_HOME"/lib/*.jar
    do CLASSPATH=${CLASSPATH}:${jar}
done

for jar in "$APP_HOME"/target/*.jar
    do CLASSPATH=${CLASSPATH}:${jar}
done

for jar in "$APP_HOME"/target/lib/*.jar
    do CLASSPATH=${CLASSPATH}:${jar}
done

echo "log config path:" $APP_HOME/config/log4j2-$ENV_ACTIVE.xml

function start(){
    RUNNING=`ps -ef|grep $PRG_NAME|grep -v grep|awk '{print $2}'`
    if [ -n "$RUNNING" ]; then
        echo "$PRG_NAME is running! $RUNNING"
    else
        echo "nohup $JAVA_HOME/bin/java $JAVA_OPTS -jar $PRG_NAME --spring.config.location=$APP_HOME/config --logging.config=$APP_HOME/config/log4j2-$ENV_ACTIVE.xml &"
        exec nohup $JAVA_HOME/bin/java $JAVA_OPTS -jar $PRG_NAME --spring.config.location=$APP_HOME/config --logging.config=$APP_HOME/config/log4j2-$ENV_ACTIVE.xml>/dev/null 2>&1
        if [ $? -eq 0 ];then
            echo "$PRG_NAME start success"
        else
            echo "$PRG_NAME start failed"
            exit 1
        fi
    fi
}

function status(){
    processid=`pgerp -f "PRG_NAME"`
    if [ $processid ];then
        echo "$PRG_NAME is running as process $processid"
    else
        echo "$PRG_NAME is not running."
    fi
}

function stop(){
    echo " stopping $PRG_NAME..."
    pkill -f "$PRG_NAME"
    echo "$PRG_NAME is stopped!"
}

case $1 in
    --help|-help|-h)
    print_usage
    exit
    ;;

    start)
        start
        ;;
    stop)
        stop
        ;;
    status)
        status
        ;;
    restart)
        stop
        start
        ;;
    *)
esac
exit $?;