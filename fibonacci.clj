(ns clojurelogic.fibonacci
  (:gen-class))

(defn fib
  ([num]
    (fib num 0 [] -1 1))

  ([num counter fib-series f1 f2]
    (let [f3 (+ f1 f2)]
      (if (<= num 1)
        [f3]
        (if (= counter num)
          fib-series
          (recur num
                 (inc counter)
                 (conj fib-series f3)
                 f2
                 f3))))))