(ns db.service
  (:require [datomic.client.api :as d]))


(def client (d/client {:server-type :dev-local
                       :system      "dev"}))

(comment
  (d/create-database client {:db-name "loja"})
  (d/delete-database client {:db-name "loja"}))

(def conn (d/connect client {:db-name "loja"}))
