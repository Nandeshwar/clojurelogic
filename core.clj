(ns clojurelogic.core
  (:require [clojurelogic.welcome1      :as w])
  (:require [clojurelogic.EvenOdd       :as evenOdd])
  (:require [clojurelogic.EvenOddBetween :as evenOddBetween])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
    (w/welcome)

  ;; Begin: check if number is even or odd
  (println "Enter a number to check if it is even or not")
  (let [num (read-line)]

    ;; library function - even? odd?
    ;; (if (= (even? (Integer/parseInt num))

    (if (= (evenOdd/isEven (Integer/parseInt num))
           true)
      (println "Even")
      (println "Odd")))
  ;; End: check if number is even or odd

  ;; Find the even and odd numbers between given range
  (println "Enter two begin and end numbers to find the odd and even numbers between both")
  (let [begin (Integer/parseInt (read-line))
        end (Integer/parseInt (read-line))]
    (println (evenOddBetween/evenOddList begin end)))

  )
