(ns clojurelogic.age-group)

(defn age-group [age]
  (cond
    (and (> age 0)
         (< age 13)) "Child"
    (and (> age 12)
         (< age 20)) "Teen"
    (and (> age 19)
         (< age 45)) "Adult"
    (and (> age 44)
         (< age 120)) "Old"
    :else "Invalid"))