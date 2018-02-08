(ns clojurelogic.prime-number)

(defn is-prime
  ([num]
    (let [begin 2
          end1 (+ (quot num 2)
                 1)
          end (bigint (inc (Math/sqrt num)))       ]
      (is-prime num begin end)))

  ([num begin end]
    (if (= begin end)
      true
      (do
        (if (zero? (mod num begin))
          false
          (recur num (inc begin) end))))))



(defn divisible? [a b]
  (zero? (mod a b)))

(defn prime? [n]
  (and (> n 1)
       (not-any?
        (partial divisible? n)
        (range 2 n))))