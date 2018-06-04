(ns test.core
  (:require [datomic.client.api :as d]
            [clojure.java.io :as io]))

(def resource io/resource)

(defn read-cfg []
   (read-string (slurp (resource "db-config.edn"))))

(defn connect-client []
  (d/client (read-cfg)))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (connect-client)})
