(ns cljs-test-runner.test-runner
  (:require [cljs-test-runner.main]
            [clojure.java.io :as io]))

(defmacro run-tests [options]
  (let [cl (.getContextClassLoader (Thread/currentThread))]
    (.setContextClassLoader (Thread/currentThread) (clojure.lang.DynamicClassLoader. cl)))
  (cljs-test-runner.main/test-cljs-namespaces-in-dir
    (merge {:out "cljs-test-runner-out", :env :node, :dir #{"test"} :no-exit true}
      options)))
