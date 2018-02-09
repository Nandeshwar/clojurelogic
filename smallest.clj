(ns clojurelogic.smallest)

(defn- smallest-between [num1 num2]
  (if (< num1 num2)
    num1
    num2))

(defn find-smallest
  ([numbers]
   (find-smallest (first numbers) (first numbers) (rest numbers)))

  ([smallest-num first-num numbers]
   (if (empty? numbers)
     (smallest-between smallest-num first-num)
     (if (> smallest-num first-num)
       (recur first-num
         (first numbers)
         (rest numbers))
       (recur smallest-num
         (first numbers)
         (rest numbers))))))