(ns clojurelogic.matrix-add)

(defn- add [n1 n2]
  (map #(+ %1 %2) n1 n2))

(defn matrix-add [num1 num2]
  (map add num1 num2))

(defn matrix-add-main []
  (let [num1 [
               [1, 2]
               [3, 4]]
        num2 [
               [5, 6]
               [7, 8]]]
    (println "Matrix addition result: "(matrix-add num1 num2))))