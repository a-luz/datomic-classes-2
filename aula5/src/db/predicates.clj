(ns db.predicates)

(defn string-not-empty?
  [s]
  (if (not-empty s)
    true
    false))
