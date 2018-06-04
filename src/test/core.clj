(ns test.core
  (:require [datomic.client.api :as d]))

;; hardcoded config
(def cfg
  {:server-type :cloud
   :region "eu-central-1" ;; e.g. us-east-1
   :system "juraj-datomic-cloud"
   :query-group "juraj-datomic-cloud"
   :endpoint "http://entry.juraj-datomic-cloud.eu-central-1.datomic.net:8182/"
   :proxy-port 8182
   :creds-profile "juraj-datomic-cloud"})

(defn connect-client []
  (d/client cfg))

(defn handler [request]
  (let [db (d/db (d/connect (connect-client) {:db-name "movies"}))
        all-titles-q '[:find ?movie-title 
                       :where [_ :movie/title ?movie-title]]]
    {:status 200
     :headers {"Content-Type" "text/plain"}
     :body (pr-str (d/q all-titles-q db))}))
