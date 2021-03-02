while [ 1=1 ]
  do
    curl http://localhost:8081/testAsync
    curl http://localhost:8081/testChannelPubSub
    curl http://localhost:8081/testChannelBasic
    curl http://localhost:8081/testCancel
    curl http://localhost:8081/hello
    curl http://localhost:8081/testTimeout
    sleep 1
  done
