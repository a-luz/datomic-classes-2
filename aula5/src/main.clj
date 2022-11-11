(ns main
  (:require
   [datomic.client.api :as d]
   [db.service :as service]))


(defn query-clientes
  [db]
  (d/q '[:find (pull ?e [*])
         :where
         [?e :cliente/nome ?cliente-nome]]
       db))

(defn clientes
  []
  (let [db (d/db service/conn)]
    (query-clientes db)))


(defn query-lojas
  [db]
  (d/q '[:find (pull ?e [*])
         :where
         [?e :loja/nome ?loja-nome]]
       db))

(defn lojas
  []
  (let [db (d/db service/conn)]
    (query-lojas db)))


(defn query-produtos
  [db]
  (d/q '[:find (pull ?e [*])
         :where
         [?e :produto/nome ?produto-nome]]
       db))

(defn produtos
  []
  (let [db (d/db service/conn)]
    (query-produtos db)))

(defn atualiza-preco
  [desconto preco-atual]
  (int (* (- 1 (/ desconto 100)) preco-atual)))


(defn desconto-produtos
  [produtos desconto]
  (map (fn [lista-produto]
         (-> lista-produto
             first
             (update :produto/preco #(atualiza-preco desconto %))
             (dissoc :db/id)))
       produtos))

(defn persistir-descontos
  [desconto]
  (let [produtos (produtos)
        produtos-com-desconto (desconto-produtos produtos desconto)]
    (d/transact service/conn {:tx-data produtos-com-desconto})))



;; SINCE
;; Tudo a partir do instant X

;; ----------------|>------------------

;; AS-OF
;; Tudo antes do instant X

;; ----------------<|------------------

;; Trazendo documentacao de uma transacao junto com o instante que ela ocorreu:
;; (d/q '[:find ?e ?instante ?doc :where [?e :db/txInstant ?instante] [?e :db/doc ?doc]] (d/db service/conn))

;; pegando ids de transacoes
;; (d/q '[:find (max 3 ?tx) :where [?tx :db/txInstant]] (d/db service/conn))

;; (d/q '[:find ?tx ?instante :where [?tx :db/txInstant ?instante]] (d/since (d/db service/conn) #inst "2022-01-01"))

;; db no instante da transacao de id X
;; (def db-before (d/as-of (d/db service/conn) X)


(def pattern
  [:compras-promocao/cliente+produto
   {:compras-promocao/cliente
    [:cliente/id :cliente/nome]}
   {:compras/produto
    [:produto/nome :produto/preco]}])


;; catch de erro para quando a verificacao do predicado falha
;; (try (d/transact service/conn
;;                  {:tx-data
;;                   [{:produto/id "59deee35-8bb3-4f8f-9a5d-690045f37d81",
;;                     :produto/nome "",
;;                     :produto/tipo :informatica,
;;                     :produto/quantidade 50,
;;                     :produto/preco 500}]})
;;      (catch Exception e (ex-data e)))



