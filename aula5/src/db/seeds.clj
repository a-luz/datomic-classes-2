(ns db.seeds)

(def seed-produto
  [{:produto/id (str (java.util.UUID/randomUUID))
    :produto/nome "Televisao"
    :produto/tipo :eletrodomesticos
    :produto/quantidade 10
    :produto/preco 3000}
   
   {:produto/id (str (java.util.UUID/randomUUID))
    :produto/nome "Geladeira"
    :produto/tipo :eletrodomesticos
    :produto/quantidade 200
    :produto/preco 5000}
   
   {:produto/id (str (java.util.UUID/randomUUID))
    :produto/nome "Máquina de Lavar Roupas"
    :produto/tipo :eletrodomesticos
    :produto/quantidade 90
    :produto/preco 2000}
   
   {:produto/id (str (java.util.UUID/randomUUID))
    :produto/nome "Laptop"
    :produto/tipo :informatica
    :produto/quantidade 100
    :produto/preco 6000}
   {:produto/id (str (java.util.UUID/randomUUID))
    :produto/nome "Monitor"
    :produto/tipo :informatica
    :produto/quantidade 50
    :produto/preco 500}])


(def seed-cliente
  [{:cliente/id (str (java.util.UUID/randomUUID))
    :cliente/nome "cliente 1"}
   {:cliente/id (str (java.util.UUID/randomUUID))
    :cliente/nome "cliente 2"}
   {:cliente/id (str (java.util.UUID/randomUUID))
    :cliente/nome "cliente 3"}
   {:cliente/id (str (java.util.UUID/randomUUID))
    :cliente/nome "cliente 4"}])


(def seed-loja
  [{:loja/id (str (java.util.UUID/randomUUID))
    :loja/nome "loja 1"
    :loja/endereco "Endereco 1"}
   {:loja/id (str (java.util.UUID/randomUUID))
    :loja/nome "loja 2"
    :loja/endereco "Endereco 2"}])
