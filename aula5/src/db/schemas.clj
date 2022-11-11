(ns db.schemas)

(def tipo-produto
  [{:db/ident :eletrodomesticos}
   {:db/ident :informatica}])

(def schema-produto
  [{:db/ident :produto/id
    :db/cardinality :db.cardinality/one
    :db/unique :db.unique/identity
    :db/valueType :db.type/string
    :db.attr/preds 'db.predicates/string-not-empty?}
   
   {:db/ident :produto/nome
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/string
    :db.attr/preds 'db.predicates/string-not-empty?}
   
   {:db/ident :produto/tipo
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/ref}
   
   {:db/ident :produto/quantidade
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/long}
   
   {:db/ident :produto/preco
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/long}])


(def schema-cliente
  [{:db/ident :cliente/id
    :db/cardinality :db.cardinality/one
    :db/unique :db.unique/identity
    :db/valueType :db.type/string
    :db.attr/preds 'db.predicates/string-not-empty?}
   
   {:db/ident :cliente/nome
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/string
    :db.attr/preds 'db.predicates/string-not-empty?}])

(def schema-loja
  [{:db/ident :loja/id
    :db/cardinality :db.cardinality/one
    :db/unique :db.unique/identity
    :db/valueType :db.type/string}
   
   {:db/ident :loja/nome
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/string}

   {:db/ident :loja/endereco
    :db/cardinality :db.cardinality/one
    :db/valueType :db.type/string}])
