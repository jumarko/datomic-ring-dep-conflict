(defproject test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.datomic/client-cloud "0.8.52"
                  :exclusions [org.eclipse.jetty/jetty-client
                               org.eclipse.jetty/jetty-http
                               org.eclipse.jetty/jetty-util]]
                 [environ "1.1.0"]
                 [cheshire "5.8.0"]
                 [ring "1.7.0-RC1"]
                 [ring/ring-defaults "0.2.3"]
                 [ring/ring-json "0.4.0"]
                 [ring-cors "0.1.9"]
                 [compojure "1.6.1"]
                 [hickory "0.7.0"]
                 [markdown-clj "0.9.94"]
                 ]
  :ring {:handler test.core/handler}
  :plugins [[lein-ring "0.12.4"]]
  :main ^:skip-aot test.core
  :target-path "target/%s"
  :profiles {
   ;; :production {:env {:db-name "production"}
   ;;              :dependencies [[javax.serverlet/servlet-api "2.5"]
   ;;                             [ring/ring-mock "0.3.2"]]}
   :dev {:env {:db-name "development"}
         :dependencies [
                        ;; [javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]
                        ]}
   ;; :test {:env {:testing true}
   ;;        :dependencies [[javax.servlet/servlet-api "2.5"]
   ;;                       [ring/ring-mock "0.3.2"]]}
   })
