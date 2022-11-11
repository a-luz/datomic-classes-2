(ns exercicio
  (:require
   [datomic.client.api :as d]
   [db.service :as service]))

;; Criar transacoes para adicionar os schemas de produtos, clientes e lojas na base (presentes no arquivo `db.schemas`);

;; Criar transacao para inserir os produtos, clientes e lojas presentes no arquivo `db.seed`;

;; Criar o schema compras-promocao contendo id, valor da compra, referencia para os produtos, cliente e loja existentes, e criar uma composicao da forma :compras-promocao/cliente+produto para a entidade de compras-promocao;

;; Criar e Inserir entidades de compras;

;; Criar query de compras, retornando todos os produtos, cliente e lojas presentes nas compras;

;; Criar e rodar transacao para reduzir a quantidade de um produto X;

;; Trazer a quantidade do produto X antes da transacao e depois da transacao utilizando as-of e since.

