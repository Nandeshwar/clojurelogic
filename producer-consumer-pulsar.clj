; in project.clj
; :dependencies [
;                 [co.paralleluniverse/quasar-core "0.7.9"]
;                 [co.paralleluniverse/pulsar "0.7.9"]
;                 ]
;  :java-agents [[co.paralleluniverse/quasar-core "0.7.6"]]

(ns ep-clojure.core
  (:require
    [co.paralleluniverse.pulsar
     [core :refer :all]
     [actors :refer :all]]

    [co.paralleluniverse.pulsar.async
     :refer [>! <! >!! <!! go chan buffer thread
             alts! alts!! timeout]]
    )
  (:gen-class))

; producer consumer: using core.async library
(defn producer [proucer-channel message]
  (go (doseq [i (range 10)]
        (>!! proucer-channel (str message ":" i)))))

(defn consumer [producer-channel receiver-channel]
  (go (doseq [_ (range 10)]
        (let [x (<!! producer-channel)]
          (>!! receiver-channel x)))))


; producer consumer : using pulsar library
(defn producer-pulsar [producer-channel message]
  (doseq [i (range 10)]
    (snd producer-channel (str message ":" i))))

(defn consumer-pulsar [producer-channel receiver-channel]
  (doseq [_ (range 10)]
    (let [x (rcv producer-channel)]
      (snd receiver-channel x))))

(defn -main
  [& args]

  ; producer consumer: using core.async library
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

  ; producer consumer: using pulsar library
  (let [p-chan (channel 5)
        r-chan (channel 7)]
    (spawn-fiber producer-pulsar p-chan "Nandeshwar")
    (spawn-fiber consumer-pulsar p-chan r-chan)

    (fiber (doseq [_ (range 10)]
             (println (rcv r-chan)))))

  (println "Hello, World!"))
