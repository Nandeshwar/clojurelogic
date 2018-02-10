(ns clojurelogic.factorial)

(defn fact
  ([num]
   (fact num 1))

  ([num result]
   (if (zero? num)
     result
     (let [result (* result num)]
       (recur (dec num) result)))))