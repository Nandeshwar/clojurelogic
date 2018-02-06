(ns clojurelogic.EvenOdd)

(defn isEven [num]
  (if (= (mod num 2) 0)
    true
    false))