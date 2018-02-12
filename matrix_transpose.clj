(ns clojurelogic.matrix-transpose)

(defn- convert-row-to-column
  "input: [1 2]
           output: [[1]
                    [2]]"
  [row]
  (defn wrap-num-to-vector [num]
    [num])

  (let [columns (map wrap-num-to-vector row)]
    columns))

(defn- append-row-to-column
  "input 1 - result: [[1]
                              [2]]
           input 2 - row: [3, 4]
           ouput- [[1,3]
                   [2, 4]]"
  [result row]
  (defn append-to-column [res-col row-item]
    (conj res-col row-item))

  (let [columns (map append-to-column result row)]
    columns))

(defn matrix-transpose
  ([mat]

   (matrix-transpose [] mat))

  ([result mat]
   (if (empty? mat)
     result
     (let [result (if (empty? result )
                    (map convert-row-to-column [(first mat)])
                    (map append-row-to-column result [(first mat)]))]

       (recur result (rest mat))))))

(defn matrix-transpose-main []
  (let [num [
              [1, 2 3]
              [4, 5 6]
              [7, 8 9]]]
    (println "Matrix transpose of : " num "=" (matrix-transpose num))))