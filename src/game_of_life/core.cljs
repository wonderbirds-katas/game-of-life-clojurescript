(ns ^:figwheel-hooks game-of-life.core
  (:require-macros
    [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async :refer [chan close!]]))

(defn timeout [ms]
  (let [c (chan)]
    (js/setTimeout (fn [] (close! c)) ms)
    c))

(def canvas (.getElementById js/document "canvas"))
(def ctx (.getContext canvas "2d"))
(def cell-width 30)

(defn draw-cell
  "draw a cell at position (x, y), where (0,0) is the top left corner."
  [x y]
  (set! (.-fillStyle ctx) "rgb(0,0,0)")
  (.beginPath ctx)
  (.rect ctx (* x cell-width) (* y cell-width) 30 30)
  (.fill ctx))

;; Clearing the canvas removes the need for reloading the page in the REPL
;; if we have changed the code to draw onto the canvas.
(defn init-canvas
  "Clear the canvas and draw an outline around it."
  []
  (.clearRect ctx 0 0 (.-width canvas) (.-height canvas))
  (.beginPath ctx)
  (set! (.-strokeStyle ctx) "black")
  (.rect ctx 0 0 (.-width canvas) (.-height canvas))
  (.stroke ctx))

(init-canvas)
(defn draw-frame [x]
  (draw-cell x 0))

(go
  (loop [i 0]
    (draw-frame i)
    (<! (timeout 50))
    (if (< i 10)
      (recur (inc i)))))
