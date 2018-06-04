# datomic cloud and ring dep conflict example

To see the error you need to:

1) Have a datomic cloud instance running and add the config to `resources/db-config.edn`.
2) Run `lein ring server`

The browser window should open with a stack trace and/or you'll see the stack trace in the console.

Here's the error I get:


```
2018-06-03 21:51:41.368:INFO::main: Logging initialized @1557ms
2018-06-03 21:51:43.927:INFO:oejs.Server:main: jetty-9.2.24.v20180105
2018-06-03 21:51:43.989:INFO:oejs.ServerConnector:main: Started ServerConnector@587400a9{HTTP/1.1}{0.0.0.0:3000}
2018-06-03 21:51:43.989:INFO:oejs.Server:main: Started @4178ms
Started server on port 3000
clojure.lang.Compiler$CompilerException: java.lang.ClassNotFoundException: org.eclipse.jetty.client.HttpClient, compiling:(cognitect/http_client.clj:1:1)
       Compiler.java:7526 clojure.lang.Compiler.load
              RT.java:379 clojure.lang.RT.loadResourceScript
              RT.java:370 clojure.lang.RT.loadResourceScript
              RT.java:460 clojure.lang.RT.load
              RT.java:426 clojure.lang.RT.load
            core.clj:6046 clojure.core/load[fn]
            core.clj:6045 clojure.core/load
            core.clj:6029 clojure.core/load
          RestFn.java:408 clojure.lang.RestFn.invoke
            core.clj:5848 clojure.core/load-one
            core.clj:5843 clojure.core/load-one
            core.clj:5888 clojure.core/load-lib[fn]
            core.clj:5887 clojure.core/load-lib
            core.clj:5868 clojure.core/load-lib
          RestFn.java:142 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5925 clojure.core/load-libs
            core.clj:5909 clojure.core/load-libs
          RestFn.java:137 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5947 clojure.core/require
            core.clj:5947 clojure.core/require
          RestFn.java:703 clojure.lang.RestFn.invoke
            shared.clj:16 datomic.client.impl.shared/eval14044[fn]
            shared.clj:16 datomic.client.impl.shared/eval14044
            shared.clj:16 datomic.client.impl.shared/eval14044
       Compiler.java:7062 clojure.lang.Compiler.eval
       Compiler.java:7051 clojure.lang.Compiler.eval
       Compiler.java:7514 clojure.lang.Compiler.load
              RT.java:379 clojure.lang.RT.loadResourceScript
              RT.java:370 clojure.lang.RT.loadResourceScript
              RT.java:460 clojure.lang.RT.load
              RT.java:426 clojure.lang.RT.load
            core.clj:6046 clojure.core/load[fn]
            core.clj:6045 clojure.core/load
            core.clj:6029 clojure.core/load
          RestFn.java:408 clojure.lang.RestFn.invoke
            core.clj:5848 clojure.core/load-one
            core.clj:5843 clojure.core/load-one
            core.clj:5888 clojure.core/load-lib[fn]
            core.clj:5887 clojure.core/load-lib
            core.clj:5868 clojure.core/load-lib
          RestFn.java:142 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5925 clojure.core/load-libs
            core.clj:5909 clojure.core/load-libs
          RestFn.java:137 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5947 clojure.core/require
            core.clj:5947 clojure.core/require
          RestFn.java:482 clojure.lang.RestFn.invoke
              sync.clj:16 datomic.client.api.sync/eval4647[fn]
              sync.clj:16 datomic.client.api.sync/eval4647
              sync.clj:16 datomic.client.api.sync/eval4647
       Compiler.java:7062 clojure.lang.Compiler.eval
       Compiler.java:7051 clojure.lang.Compiler.eval
       Compiler.java:7514 clojure.lang.Compiler.load
              RT.java:379 clojure.lang.RT.loadResourceScript
              RT.java:370 clojure.lang.RT.loadResourceScript
              RT.java:460 clojure.lang.RT.load
              RT.java:426 clojure.lang.RT.load
            core.clj:6046 clojure.core/load[fn]
            core.clj:6045 clojure.core/load
            core.clj:6029 clojure.core/load
          RestFn.java:408 clojure.lang.RestFn.invoke
            core.clj:5848 clojure.core/load-one
            core.clj:5843 clojure.core/load-one
            core.clj:5888 clojure.core/load-lib[fn]
            core.clj:5887 clojure.core/load-lib
            core.clj:5868 clojure.core/load-lib
          RestFn.java:142 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5925 clojure.core/load-libs
            core.clj:5909 clojure.core/load-libs
          RestFn.java:137 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5947 clojure.core/require
            core.clj:5947 clojure.core/require
          RestFn.java:408 clojure.lang.RestFn.invoke
              impl.clj:10 datomic.client.api.impl/dynaload
               impl.clj:7 datomic.client.api.impl/dynaload
              impl.clj:25 datomic.client.api.impl/dynacall
              impl.clj:23 datomic.client.api.impl/dynacall
               api.clj:78 datomic.client.api/client
               api.clj:44 datomic.client.api/client
              core.clj:11 test.core/connect-client
              core.clj:10 test.core/connect-client
              core.clj:16 test.core/handler
              core.clj:13 test.core/handler
             Var.java:381 clojure.lang.Var.invoke
            reload.clj:39 ring.middleware.reload/wrap-reload[fn]
        stacktrace.clj:26 ring.middleware.stacktrace/wrap-stacktrace-log[fn]
        stacktrace.clj:96 ring.middleware.stacktrace/wrap-stacktrace-web[fn]
             jetty.clj:26 ring.adapter.jetty/proxy-handler[fn]
         (Unknown Source) ring.adapter.jetty.proxy$org.eclipse.jetty.server.handler.AbstractHandler$ff19274a.handle
   HandlerWrapper.java:97 org.eclipse.jetty.server.handler.HandlerWrapper.handle
          Server.java:499 org.eclipse.jetty.server.Server.handle
     HttpChannel.java:311 org.eclipse.jetty.server.HttpChannel.handle
  HttpConnection.java:258 org.eclipse.jetty.server.HttpConnection.onFillable
AbstractConnection.java:544 org.eclipse.jetty.io.AbstractConnection$2.run
QueuedThreadPool.java:635 org.eclipse.jetty.util.thread.QueuedThreadPool.runJob
QueuedThreadPool.java:555 org.eclipse.jetty.util.thread.QueuedThreadPool$3.run
          Thread.java:745 java.lang.Thread.run
Caused by: java.lang.ClassNotFoundException: org.eclipse.jetty.client.HttpClient
  URLClassLoader.java:381 java.net.URLClassLoader.findClass
DynamicClassLoader.java:69 clojure.lang.DynamicClassLoader.findClass
     ClassLoader.java:424 java.lang.ClassLoader.loadClass
DynamicClassLoader.java:77 clojure.lang.DynamicClassLoader.loadClass
     ClassLoader.java:357 java.lang.ClassLoader.loadClass
         (Unknown Source) java.lang.Class.forName0
           Class.java:348 java.lang.Class.forName
             RT.java:2204 clojure.lang.RT.classForName
             RT.java:2217 clojure.lang.RT.classForNameNonLoading
       http_client.clj:16 cognitect.http-client/eval14163[fn]
       http_client.clj:16 cognitect.http-client/eval14163
       http_client.clj:16 cognitect.http-client/eval14163
       Compiler.java:7062 clojure.lang.Compiler.eval
       Compiler.java:7051 clojure.lang.Compiler.eval
       Compiler.java:7514 clojure.lang.Compiler.load
clojure.lang.Compiler$CompilerException: java.lang.ClassNotFoundException: org.eclipse.jetty.client.HttpClient, compiling:(cognitect/http_client.clj:1:1)
       Compiler.java:7526 clojure.lang.Compiler.load
              RT.java:379 clojure.lang.RT.loadResourceScript
              RT.java:370 clojure.lang.RT.loadResourceScript
              RT.java:460 clojure.lang.RT.load
              RT.java:426 clojure.lang.RT.load
            core.clj:6046 clojure.core/load[fn]
            core.clj:6045 clojure.core/load
            core.clj:6029 clojure.core/load
          RestFn.java:408 clojure.lang.RestFn.invoke
            core.clj:5848 clojure.core/load-one
            core.clj:5843 clojure.core/load-one
            core.clj:5888 clojure.core/load-lib[fn]
            core.clj:5887 clojure.core/load-lib
            core.clj:5868 clojure.core/load-lib
          RestFn.java:142 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5925 clojure.core/load-libs
            core.clj:5909 clojure.core/load-libs
          RestFn.java:137 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5947 clojure.core/require
            core.clj:5947 clojure.core/require
          RestFn.java:703 clojure.lang.RestFn.invoke
            shared.clj:16 datomic.client.impl.shared/eval14175[fn]
            shared.clj:16 datomic.client.impl.shared/eval14175
            shared.clj:16 datomic.client.impl.shared/eval14175
       Compiler.java:7062 clojure.lang.Compiler.eval
       Compiler.java:7051 clojure.lang.Compiler.eval
       Compiler.java:7514 clojure.lang.Compiler.load
              RT.java:379 clojure.lang.RT.loadResourceScript
              RT.java:370 clojure.lang.RT.loadResourceScript
              RT.java:460 clojure.lang.RT.load
              RT.java:426 clojure.lang.RT.load
            core.clj:6046 clojure.core/load[fn]
            core.clj:6045 clojure.core/load
            core.clj:6029 clojure.core/load
          RestFn.java:408 clojure.lang.RestFn.invoke
            core.clj:5848 clojure.core/load-one
            core.clj:5843 clojure.core/load-one
            core.clj:5888 clojure.core/load-lib[fn]
            core.clj:5887 clojure.core/load-lib
            core.clj:5868 clojure.core/load-lib
          RestFn.java:142 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5925 clojure.core/load-libs
            core.clj:5909 clojure.core/load-libs
          RestFn.java:137 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5947 clojure.core/require
            core.clj:5947 clojure.core/require
          RestFn.java:482 clojure.lang.RestFn.invoke
              sync.clj:16 datomic.client.api.sync/eval14169[fn]
              sync.clj:16 datomic.client.api.sync/eval14169
              sync.clj:16 datomic.client.api.sync/eval14169
       Compiler.java:7062 clojure.lang.Compiler.eval
       Compiler.java:7051 clojure.lang.Compiler.eval
       Compiler.java:7514 clojure.lang.Compiler.load
              RT.java:379 clojure.lang.RT.loadResourceScript
              RT.java:370 clojure.lang.RT.loadResourceScript
              RT.java:460 clojure.lang.RT.load
              RT.java:426 clojure.lang.RT.load
            core.clj:6046 clojure.core/load[fn]
            core.clj:6045 clojure.core/load
            core.clj:6029 clojure.core/load
          RestFn.java:408 clojure.lang.RestFn.invoke
            core.clj:5848 clojure.core/load-one
            core.clj:5843 clojure.core/load-one
            core.clj:5888 clojure.core/load-lib[fn]
            core.clj:5887 clojure.core/load-lib
            core.clj:5868 clojure.core/load-lib
          RestFn.java:142 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5925 clojure.core/load-libs
            core.clj:5909 clojure.core/load-libs
          RestFn.java:137 clojure.lang.RestFn.applyTo
             core.clj:659 clojure.core/apply
            core.clj:5947 clojure.core/require
            core.clj:5947 clojure.core/require
          RestFn.java:408 clojure.lang.RestFn.invoke
              impl.clj:10 datomic.client.api.impl/dynaload
               impl.clj:7 datomic.client.api.impl/dynaload
              impl.clj:25 datomic.client.api.impl/dynacall
              impl.clj:23 datomic.client.api.impl/dynacall
               api.clj:78 datomic.client.api/client
               api.clj:44 datomic.client.api/client
              core.clj:11 test.core/connect-client
              core.clj:10 test.core/connect-client
              core.clj:16 test.core/handler
              core.clj:13 test.core/handler
             Var.java:381 clojure.lang.Var.invoke
            reload.clj:39 ring.middleware.reload/wrap-reload[fn]
        stacktrace.clj:26 ring.middleware.stacktrace/wrap-stacktrace-log[fn]
        stacktrace.clj:96 ring.middleware.stacktrace/wrap-stacktrace-web[fn]
             jetty.clj:26 ring.adapter.jetty/proxy-handler[fn]
         (Unknown Source) ring.adapter.jetty.proxy$org.eclipse.jetty.server.handler.AbstractHandler$ff19274a.handle
   HandlerWrapper.java:97 org.eclipse.jetty.server.handler.HandlerWrapper.handle
          Server.java:499 org.eclipse.jetty.server.Server.handle
     HttpChannel.java:311 org.eclipse.jetty.server.HttpChannel.handle
  HttpConnection.java:258 org.eclipse.jetty.server.HttpConnection.onFillable
AbstractConnection.java:544 org.eclipse.jetty.io.AbstractConnection$2.run
QueuedThreadPool.java:635 org.eclipse.jetty.util.thread.QueuedThreadPool.runJob
QueuedThreadPool.java:555 org.eclipse.jetty.util.thread.QueuedThreadPool$3.run
          Thread.java:745 java.lang.Thread.run
Caused by: java.lang.ClassNotFoundException: org.eclipse.jetty.client.HttpClient
  URLClassLoader.java:381 java.net.URLClassLoader.findClass
DynamicClassLoader.java:69 clojure.lang.DynamicClassLoader.findClass
     ClassLoader.java:424 java.lang.ClassLoader.loadClass
DynamicClassLoader.java:77 clojure.lang.DynamicClassLoader.loadClass
     ClassLoader.java:357 java.lang.ClassLoader.loadClass
         (Unknown Source) java.lang.Class.forName0
           Class.java:348 java.lang.Class.forName
             RT.java:2204 clojure.lang.RT.classForName
             RT.java:2217 clojure.lang.RT.classForNameNonLoading
       http_client.clj:16 cognitect.http-client/eval14181[fn]
       http_client.clj:16 cognitect.http-client/eval14181
       http_client.clj:16 cognitect.http-client/eval14181
       Compiler.java:7062 clojure.lang.Compiler.eval
       Compiler.java:7051 clojure.lang.Compiler.eval
       Compiler.java:7514 clojure.lang.Compiler.load
```

