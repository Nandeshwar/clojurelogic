(ns clojurelogic.reverseNumber
  (gen-class))

(defn reverseNum
  ([num]
    (reverseNum num 0))

  ([num reverse]
   (let [rem (mod num 10)
         num (quot num 10)
         rev (+ (* reverse 10)
                rem)]
     (if (<= num 0)
       rev
       (recur num rev)))))
