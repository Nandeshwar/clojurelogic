(ns clojurelogic.EvenOddBetween)

(defn evenOddList[begin end]
  (let [numRange (range begin
                        (+ end
                           1))
        evenList (filter even? numRange)
        oddList (filter odd? numRange)] [evenList oddList]))
