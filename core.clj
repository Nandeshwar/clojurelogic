(ns clojurelogic.core
  (:require [clojurelogic.welcome1      :as w])
  (:require [clojurelogic.EvenOdd       :as evenOdd])
  (:require [clojurelogic.EvenOddBetween :as evenOddBetween])
  (:require [clojurelogic.reverseNumber :as reverseNumber])
  (:require [clojurelogic.fibonacci :as fibonacci])
  (:require [clojurelogic.prime-number :as prime])
  (:require [clojurelogic.age-group :as age-group])
  (:require [clojurelogic.smallest :as smallest])
  (:require [clojurelogic.sorting :as sorting])
  (:require [clojurelogic.factorial :as factorial])
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

  ;; Begin: Find the even and odd numbers between given range
  (println "Enter two begin and end numbers to find the odd and even numbers between both")
  (let [begin (Integer/parseInt (read-line))
        end (Integer/parseInt (read-line))]
    (println (evenOddBetween/evenOddList begin end)))
  ;; End: Find the even and odd numbers between given range

  (println "Fibbonacci series: " (fibonacci/fib 5))
  (println "Reverse of 123: " (reverseNumber/reverseNum 123))
  (println "is 11 prime number: " (prime/is-prime 11))
  (println "is 9 prime number: " (prime/is-prime 9))
  (println "Age group for 45 years is " (age-group/age-group 45))

  ;; The given below number is big prime number. It takes long time to check if it is prime. I waited 20 min and now giving up
  ;;(println "is 20988936657440586486151264256610222593863921 prime number: " (prime/is-prime 20988936657440586486151264256610222593863921))

  (println "Smallest numbers among 5 4 7 2 3 = " (smallest/find-smallest[5 4 7 2 3]))
  (println "Sorting numbers 5 4 7 2 2 3 = " (sorting/sortFun [5 4 7 2 2 3]))
  (println "Factorial of 5 = " (factorial/fact 5))

  ; Another program for factorial for big numbers which get rid of integer overflow
  ; use the *' operator which supports arbitrary precision by automatically promoting the result to BigInt in case it would overflow:

  (println "Factorial of 99"(reduce *' (range 1 100)))

  ; Put N at the end of the number which makes it a bigint,
  ;(reduce * (range 1N 1001N))


  )
