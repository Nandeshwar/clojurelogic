; Dependecy is [org.clojure/core.async "0.4.490"]

(ns ep-clojure.core
  (:require [clojure.core.async :as async
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]])
  (:gen-class))

(defn producer [proucer-channel message]
  (go (doseq [i (range 10)]
        (>!! proucer-channel (str message ":" i)))))

(defn consumer [producer-channel receiver-channel]
  (go (doseq [_ (range 10)]
        (let [x (<!! producer-channel)]
          (>!! receiver-channel x)))))

(defn -main
  [& args]
  (let [
        the-answer (promise)
        producer-channel (chan 5)
        receiver-channel (chan 6)]

    (producer producer-channel "Nandeshwar here")
    (consumer producer-channel receiver-channel)

     (go (doseq [_ (range 10)]
               (println (<!! receiver-channel))
               (deliver the-answer "done")))
    (deref the-answer))
  (println "Hello, World!"))
  
  ; output
; Nandeshwar here:0
; Hello, World!
; Nandeshwar here:1
; Nandeshwar here:2
; Nandeshwar here:3
; Nandeshwar here:4
; Nandeshwar here:5
; Nandeshwar here:6
; Nandeshwar here:7
; Nandeshwar here:8
; Nandeshwar here:9
