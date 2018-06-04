(defproject test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring/ring-core "1.7.0-RC1"]
                 [ring/ring-jetty-adapter "1.7.0-RC1"]
                 [org.eclipse.jetty/jetty-server "9.4.9.v20180320"] 
                 [org.eclipse.jetty/jetty-client "9.4.9.v20180320"] 
                 [com.datomic/client-cloud "0.8.52"]]
                 
  :ring {:handler test.core/handler}
  :plugins [[lein-ring "0.12.4"]]
  :main ^:skip-aot test.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
