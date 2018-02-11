(ns clojurelogic.matrix-transpose)

(defn- convert-row-to-column [row]
  (defn wrap-num-to-vector [num]
    [num])


  (let [r (map wrap-num-to-vector row)]
    r))

(defn- append-row-to-column [result row]
  (defn append-to-column [res-col row-item]
    (conj res-col row-item))

  (let [r (map append-to-column result row)]
    r))

(defn matrix-transpose
  ([mat]

   (matrix-transpose [] mat))

  ([result mat]
   (if (empty? mat)
     result
     (let [result (if (empty? result )
                    (map convert-row-to-column [(first mat)])
                    (map append-row-to-column result [(first mat)]))]

       (recur result (rest mat)))))
  )

(defn matrix-transpose-main []
  (let [num [
              [1, 2]
              [3, 4]]]
    (println "Matrix transpose: " (matrix-transpose num))))