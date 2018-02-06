(ns clojurelogic.core
  (:require [clojurelogic.welcome1      :as w])
  (:require [clojurelogic.EvenOdd       :as evenOdd])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
    (w/welcome)

  ;; Begin: check if number is even or odd
  (println "Enter a number")
  (let [num (read-line)]

    ;; library function - even? odd?
    ;; (if (= (even? (Integer/parseInt num))

    (if (= (evenOdd/isEven (Integer/parseInt num))
           true)
      (println "Even")
      (println "Odd")))
  ;; End: check if number is even or odd

  )
