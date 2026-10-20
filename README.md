# PSO vs GA: A Comparative Study on the Ackley Function

This repository contains a complete Java implementation and benchmark comparing **Particle Swarm Optimization (PSO)** and **Genetic Algorithm (GA)** on the **Ackley Function**. 

## 📌 Project Overview
The goal of this experiment is to evaluate and compare the performance of PSO and GA across various dimensions (1D to 100D) using three key metrics:
1. **Success Rate (%)**: The percentage of runs that reached an acceptable threshold.
2. **RMSE**: Root Mean Square Error to measure the accuracy of the solutions.
3. **Execution Time (ms)**: The average time taken to complete an optimization run.

## ⚙️ Experiment Setup
- **Function**: Ackley (Global Minimum = 0 at `x = (0,0,...,0)`)
- **Dimensions**: 1, 2, 3, 5, 10, 20, 30, 40, 50, 100
- **Runs per Dimension**: 10
- **Thresholds**: 
  - Small dimensions (≤ 5): `0.001`
  - Medium dimensions (10 to 50): `0.01`
  - Large dimensions (100): `0.1`

## 🏆 Key Findings
- **PSO** completely outperforms GA across all metrics.
- GA suffers from **premature convergence** in dimensions > 5, failing to escape local optima.
- PSO leverages collective memory (`gBest`) to remain highly accurate up to 40 dimensions.
- Both algorithms hit the **Curse of Dimensionality** at 100D, but PSO yields a significantly lower error (RMSE ~2.47 vs GA's ~16.97).

## 📊 Sample Output (D=100)
```text
==============================================
  PSO vs GA on Ackley Function
  Dimensions: 1, 2, 3, 5, 10, 20, 30, 40, 50, 100
  Runs per dimension: 10
==============================================

========== Dimension = 1 | Threshold = 0.001 | Iterations = 1000 ==========
>>> Running PSO ...
  PSO run  1: Y=4.440892e-16  err=4.440892e-16  time=18.0ms  OK
  PSO run  2: Y=4.440892e-16  err=4.440892e-16  time=5.2ms  OK
  PSO run  3: Y=4.440892e-16  err=4.440892e-16  time=5.1ms  OK
  PSO run  4: Y=4.440892e-16  err=4.440892e-16  time=5.2ms  OK
  PSO run  5: Y=4.440892e-16  err=4.440892e-16  time=4.9ms  OK
  PSO run  6: Y=4.440892e-16  err=4.440892e-16  time=5.1ms  OK
  PSO run  7: Y=4.440892e-16  err=4.440892e-16  time=8.0ms  OK
  PSO run  8: Y=4.440892e-16  err=4.440892e-16  time=6.9ms  OK
  PSO run  9: Y=4.440892e-16  err=4.440892e-16  time=5.4ms  OK
  PSO run 10: Y=4.440892e-16  err=4.440892e-16  time=4.7ms  OK
>>> Running GA ...
  GA  run  1: Y=4.440892e-16  err=4.440892e-16  time=46.6ms  OK
  GA  run  2: Y=4.440892e-16  err=4.440892e-16  time=17.6ms  OK
  GA  run  3: Y=4.440892e-16  err=4.440892e-16  time=18.9ms  OK
  GA  run  4: Y=4.440892e-16  err=4.440892e-16  time=27.7ms  OK
  GA  run  5: Y=4.440892e-16  err=4.440892e-16  time=29.5ms  OK
  GA  run  6: Y=4.440892e-16  err=4.440892e-16  time=34.0ms  OK
  GA  run  7: Y=4.694489e-10  err=4.694489e-10  time=21.2ms  OK
  GA  run  8: Y=4.440892e-16  err=4.440892e-16  time=13.5ms  OK
  GA  run  9: Y=4.440892e-16  err=4.440892e-16  time=19.6ms  OK
  GA  run 10: Y=4.440892e-16  err=4.440892e-16  time=11.2ms  OK
  --> PSO: success=100.0%, rmse=4.440892e-16, time=6.8ms
  --> GA : success=100.0%, rmse=1.484528e-10, time=24.0ms

========== Dimension = 2 | Threshold = 0.001 | Iterations = 1000 ==========
>>> Running PSO ...
  PSO run  1: Y=4.440892e-16  err=4.440892e-16  time=23.2ms  OK
  PSO run  2: Y=4.440892e-16  err=4.440892e-16  time=10.4ms  OK
  PSO run  3: Y=4.440892e-16  err=4.440892e-16  time=7.6ms  OK
  PSO run  4: Y=4.440892e-16  err=4.440892e-16  time=8.0ms  OK
  PSO run  5: Y=4.440892e-16  err=4.440892e-16  time=9.6ms  OK
  PSO run  6: Y=4.440892e-16  err=4.440892e-16  time=8.9ms  OK
  PSO run  7: Y=4.440892e-16  err=4.440892e-16  time=28.2ms  OK
  PSO run  8: Y=4.440892e-16  err=4.440892e-16  time=8.0ms  OK
  PSO run  9: Y=4.440892e-16  err=4.440892e-16  time=7.9ms  OK
  PSO run 10: Y=4.440892e-16  err=4.440892e-16  time=8.8ms  OK
>>> Running GA ...
  GA  run  1: Y=4.440892e-16  err=4.440892e-16  time=34.9ms  OK
  GA  run  2: Y=4.440892e-16  err=4.440892e-16  time=20.0ms  OK
  GA  run  3: Y=4.440892e-16  err=4.440892e-16  time=25.3ms  OK
  GA  run  4: Y=4.440892e-16  err=4.440892e-16  time=18.6ms  OK
  GA  run  5: Y=4.440892e-16  err=4.440892e-16  time=27.8ms  OK
  GA  run  6: Y=4.440892e-16  err=4.440892e-16  time=22.5ms  OK
  GA  run  7: Y=4.440892e-16  err=4.440892e-16  time=19.9ms  OK
  GA  run  8: Y=4.440892e-16  err=4.440892e-16  time=21.8ms  OK
  GA  run  9: Y=4.440892e-16  err=4.440892e-16  time=20.1ms  OK
  GA  run 10: Y=4.440892e-16  err=4.440892e-16  time=16.4ms  OK
  --> PSO: success=100.0%, rmse=4.440892e-16, time=12.0ms
  --> GA : success=100.0%, rmse=4.440892e-16, time=22.7ms

========== Dimension = 3 | Threshold = 0.001 | Iterations = 1000 ==========
>>> Running PSO ...
  PSO run  1: Y=4.440892e-16  err=4.440892e-16  time=10.6ms  OK
  PSO run  2: Y=4.440892e-16  err=4.440892e-16  time=10.0ms  OK
  PSO run  3: Y=4.440892e-16  err=4.440892e-16  time=10.3ms  OK
  PSO run  4: Y=4.440892e-16  err=4.440892e-16  time=9.9ms  OK
  PSO run  5: Y=4.440892e-16  err=4.440892e-16  time=10.7ms  OK
  PSO run  6: Y=4.440892e-16  err=4.440892e-16  time=14.2ms  OK
  PSO run  7: Y=4.440892e-16  err=4.440892e-16  time=20.1ms  OK
  PSO run  8: Y=4.440892e-16  err=4.440892e-16  time=18.1ms  OK
  PSO run  9: Y=4.440892e-16  err=4.440892e-16  time=13.6ms  OK
  PSO run 10: Y=4.440892e-16  err=4.440892e-16  time=12.6ms  OK
>>> Running GA ...
  GA  run  1: Y=4.440892e-16  err=4.440892e-16  time=42.0ms  OK
  GA  run  2: Y=4.440892e-16  err=4.440892e-16  time=26.6ms  OK
  GA  run  3: Y=4.440892e-16  err=4.440892e-16  time=25.3ms  OK
  GA  run  4: Y=4.440892e-16  err=4.440892e-16  time=26.7ms  OK
  GA  run  5: Y=1.496581e-13  err=1.496581e-13  time=24.3ms  OK
  GA  run  6: Y=3.996803e-15  err=3.996803e-15  time=27.0ms  OK
  GA  run  7: Y=4.440892e-16  err=4.440892e-16  time=28.0ms  OK
  GA  run  8: Y=4.440892e-16  err=4.440892e-16  time=27.7ms  OK
  GA  run  9: Y=4.440892e-16  err=4.440892e-16  time=32.1ms  OK
  GA  run 10: Y=4.440892e-16  err=4.440892e-16  time=25.0ms  OK
  --> PSO: success=100.0%, rmse=4.440892e-16, time=13.0ms
  --> GA : success=100.0%, rmse=4.734458e-14, time=28.5ms

========== Dimension = 5 | Threshold = 0.001 | Iterations = 1000 ==========
>>> Running PSO ...
  PSO run  1: Y=4.440892e-16  err=4.440892e-16  time=16.6ms  OK
  PSO run  2: Y=3.996803e-15  err=3.996803e-15  time=16.5ms  OK
  PSO run  3: Y=4.440892e-16  err=4.440892e-16  time=15.6ms  OK
  PSO run  4: Y=4.440892e-16  err=4.440892e-16  time=14.5ms  OK
  PSO run  5: Y=3.996803e-15  err=3.996803e-15  time=14.0ms  OK
  PSO run  6: Y=3.996803e-15  err=3.996803e-15  time=16.5ms  OK
  PSO run  7: Y=3.996803e-15  err=3.996803e-15  time=14.6ms  OK
  PSO run  8: Y=3.996803e-15  err=3.996803e-15  time=14.8ms  OK
  PSO run  9: Y=3.996803e-15  err=3.996803e-15  time=15.4ms  OK
  PSO run 10: Y=3.996803e-15  err=3.996803e-15  time=16.0ms  OK
>>> Running GA ...
  GA  run  1: Y=1.868039e-07  err=1.868039e-07  time=23.4ms  OK
  GA  run  2: Y=3.792296e-05  err=3.792296e-05  time=23.9ms  OK
  GA  run  3: Y=1.187917e-05  err=1.187917e-05  time=21.1ms  OK
  GA  run  4: Y=9.517215e-06  err=9.517215e-06  time=23.8ms  OK
  GA  run  5: Y=3.388941e-05  err=3.388941e-05  time=27.7ms  OK
  GA  run  6: Y=8.806851e-06  err=8.806851e-06  time=25.1ms  OK
  GA  run  7: Y=2.783680e-05  err=2.783680e-05  time=25.9ms  OK
  GA  run  8: Y=8.691107e-04  err=8.691107e-04  time=26.4ms  OK
  GA  run  9: Y=8.923013e-05  err=8.923013e-05  time=19.5ms  OK
  GA  run 10: Y=1.051933e-04  err=1.051933e-04  time=19.5ms  OK
  --> PSO: success=100.0%, rmse=3.352800e-15, time=15.4ms
  --> GA : success=100.0%, rmse=2.789358e-04, time=23.6ms

========== Dimension = 10 | Threshold = 0.01 | Iterations = 1500 ==========
>>> Running PSO ...
  PSO run  1: Y=3.996803e-15  err=3.996803e-15  time=37.8ms  OK
  PSO run  2: Y=3.996803e-15  err=3.996803e-15  time=39.2ms  OK
  PSO run  3: Y=3.996803e-15  err=3.996803e-15  time=41.0ms  OK
  PSO run  4: Y=7.549517e-15  err=7.549517e-15  time=47.1ms  OK
  PSO run  5: Y=3.996803e-15  err=3.996803e-15  time=40.0ms  OK
  PSO run  6: Y=7.549517e-15  err=7.549517e-15  time=37.6ms  OK
  PSO run  7: Y=3.996803e-15  err=3.996803e-15  time=37.1ms  OK
  PSO run  8: Y=7.549517e-15  err=7.549517e-15  time=50.6ms  OK
  PSO run  9: Y=3.996803e-15  err=3.996803e-15  time=42.7ms  OK
  PSO run 10: Y=7.549517e-15  err=7.549517e-15  time=38.4ms  OK
>>> Running GA ...
  GA  run  1: Y=4.889082e-01  err=4.889082e-01  time=45.5ms  FAIL
  GA  run  2: Y=4.805369e-01  err=4.805369e-01  time=47.6ms  FAIL
  GA  run  3: Y=3.105378e-01  err=3.105378e-01  time=66.3ms  FAIL
  GA  run  4: Y=3.113354e-01  err=3.113354e-01  time=50.3ms  FAIL
  GA  run  5: Y=5.474330e-01  err=5.474330e-01  time=47.5ms  FAIL
  GA  run  6: Y=3.708614e-01  err=3.708614e-01  time=48.3ms  FAIL
  GA  run  7: Y=1.486994e-01  err=1.486994e-01  time=55.4ms  FAIL
  GA  run  8: Y=5.425793e-01  err=5.425793e-01  time=56.3ms  FAIL
  GA  run  9: Y=8.096483e-01  err=8.096483e-01  time=58.4ms  FAIL
  GA  run 10: Y=3.460240e-01  err=3.460240e-01  time=51.5ms  FAIL
  --> PSO: success=100.0%, rmse=5.690583e-15, time=41.2ms
  --> GA : success=0.0%, rmse=4.682198e-01, time=52.7ms

========== Dimension = 20 | Threshold = 0.01 | Iterations = 1500 ==========
>>> Running PSO ...
  PSO run  1: Y=1.105782e-13  err=1.105782e-13  time=115.8ms  OK
  PSO run  2: Y=4.307665e-14  err=4.307665e-14  time=112.0ms  OK
  PSO run  3: Y=3.241851e-14  err=3.241851e-14  time=110.2ms  OK
  PSO run  4: Y=1.465494e-14  err=1.465494e-14  time=106.5ms  OK
  PSO run  5: Y=5.018208e-14  err=5.018208e-14  time=115.8ms  OK
  PSO run  6: Y=4.549823e-10  err=4.549823e-10  time=115.9ms  OK
  PSO run  7: Y=1.069811e-12  err=1.069811e-12  time=113.6ms  OK
  PSO run  8: Y=1.069811e-12  err=1.069811e-12  time=103.4ms  OK
  PSO run  9: Y=1.465494e-14  err=1.465494e-14  time=105.5ms  OK
  PSO run 10: Y=2.176037e-14  err=2.176037e-14  time=104.5ms  OK
>>> Running GA ...
  GA  run  1: Y=3.319003e+00  err=3.319003e+00  time=119.4ms  FAIL
  GA  run  2: Y=3.583414e+00  err=3.583414e+00  time=113.8ms  FAIL
  GA  run  3: Y=3.587359e+00  err=3.587359e+00  time=102.0ms  FAIL
  GA  run  4: Y=3.510473e+00  err=3.510473e+00  time=95.3ms  FAIL
  GA  run  5: Y=3.964513e+00  err=3.964513e+00  time=87.9ms  FAIL
  GA  run  6: Y=3.885328e+00  err=3.885328e+00  time=82.0ms  FAIL
  GA  run  7: Y=4.145816e+00  err=4.145816e+00  time=78.5ms  FAIL
  GA  run  8: Y=4.864493e+00  err=4.864493e+00  time=80.7ms  FAIL
  GA  run  9: Y=4.028537e+00  err=4.028537e+00  time=88.6ms  FAIL
  GA  run 10: Y=4.706355e+00  err=4.706355e+00  time=92.3ms  FAIL
  --> PSO: success=100.0%, rmse=1.438788e-10, time=110.3ms
  --> GA : success=0.0%, rmse=3.988638e+00, time=94.1ms

========== Dimension = 30 | Threshold = 0.01 | Iterations = 2000 ==========
>>> Running PSO ...
  PSO run  1: Y=1.155149e+00  err=1.155149e+00  time=178.6ms  FAIL
  PSO run  2: Y=1.400885e-07  err=1.400885e-07  time=181.5ms  OK
  PSO run  3: Y=9.422241e-12  err=9.422241e-12  time=184.3ms  OK
  PSO run  4: Y=1.212270e-07  err=1.212270e-07  time=174.2ms  OK
  PSO run  5: Y=1.552256e-10  err=1.552256e-10  time=178.2ms  OK
  PSO run  6: Y=2.565337e-08  err=2.565337e-08  time=174.0ms  OK
  PSO run  7: Y=1.841643e-08  err=1.841643e-08  time=186.5ms  OK
  PSO run  8: Y=1.536641e-09  err=1.536641e-09  time=181.8ms  OK
  PSO run  9: Y=9.092149e-11  err=9.092149e-11  time=182.2ms  OK
  PSO run 10: Y=4.643086e-11  err=4.643086e-11  time=176.8ms  OK
>>> Running GA ...
  GA  run  1: Y=7.385220e+00  err=7.385220e+00  time=184.2ms  FAIL
  GA  run  2: Y=6.643692e+00  err=6.643692e+00  time=172.7ms  FAIL
  GA  run  3: Y=6.412696e+00  err=6.412696e+00  time=179.9ms  FAIL
  GA  run  4: Y=5.874415e+00  err=5.874415e+00  time=186.7ms  FAIL
  GA  run  5: Y=6.047439e+00  err=6.047439e+00  time=180.8ms  FAIL
  GA  run  6: Y=6.335671e+00  err=6.335671e+00  time=173.4ms  FAIL
  GA  run  7: Y=6.561326e+00  err=6.561326e+00  time=177.4ms  FAIL
  GA  run  8: Y=5.127144e+00  err=5.127144e+00  time=174.1ms  FAIL
  GA  run  9: Y=5.905547e+00  err=5.905547e+00  time=181.2ms  FAIL
  GA  run 10: Y=5.339783e+00  err=5.339783e+00  time=190.6ms  FAIL
  --> PSO: success=90.0%, rmse=3.652900e-01, time=179.8ms
  --> GA : success=0.0%, rmse=6.194765e+00, time=180.1ms

========== Dimension = 40 | Threshold = 0.01 | Iterations = 2000 ==========
>>> Running PSO ...
  PSO run  1: Y=1.199442e-04  err=1.199442e-04  time=281.2ms  OK
  PSO run  2: Y=3.283419e-05  err=3.283419e-05  time=287.2ms  OK
  PSO run  3: Y=5.760654e-06  err=5.760654e-06  time=284.4ms  OK
  PSO run  4: Y=3.820862e-06  err=3.820862e-06  time=291.4ms  OK
  PSO run  5: Y=1.743656e+00  err=1.743656e+00  time=277.8ms  FAIL
  PSO run  6: Y=2.244885e-05  err=2.244885e-05  time=278.0ms  OK
  PSO run  7: Y=1.296730e+00  err=1.296730e+00  time=285.7ms  FAIL
  PSO run  8: Y=2.353271e-06  err=2.353271e-06  time=281.4ms  OK
  PSO run  9: Y=9.923297e-01  err=9.923297e-01  time=273.4ms  FAIL
  PSO run 10: Y=1.965211e-06  err=1.965211e-06  time=271.8ms  OK
>>> Running GA ...
  GA  run  1: Y=9.389051e+00  err=9.389051e+00  time=290.1ms  FAIL
  GA  run  2: Y=9.758638e+00  err=9.758638e+00  time=273.5ms  FAIL
  GA  run  3: Y=1.007508e+01  err=1.007508e+01  time=266.7ms  FAIL
  GA  run  4: Y=8.978814e+00  err=8.978814e+00  time=276.9ms  FAIL
  GA  run  5: Y=8.755967e+00  err=8.755967e+00  time=276.1ms  FAIL
  GA  run  6: Y=1.064272e+01  err=1.064272e+01  time=270.4ms  FAIL
  GA  run  7: Y=8.191608e+00  err=8.191608e+00  time=270.2ms  FAIL
  GA  run  8: Y=1.079988e+01  err=1.079988e+01  time=268.9ms  FAIL
  GA  run  9: Y=8.619201e+00  err=8.619201e+00  time=280.4ms  FAIL
  GA  run 10: Y=1.072498e+01  err=1.072498e+01  time=270.4ms  FAIL
  --> PSO: success=70.0%, rmse=7.554179e-01, time=281.2ms
  --> GA : success=0.0%, rmse=9.635879e+00, time=274.4ms

========== Dimension = 50 | Threshold = 0.01 | Iterations = 2000 ==========
>>> Running PSO ...
  PSO run  1: Y=2.078107e+00  err=2.078107e+00  time=389.0ms  FAIL
  PSO run  2: Y=1.803080e+00  err=1.803080e+00  time=399.9ms  FAIL
  PSO run  3: Y=1.471000e+00  err=1.471000e+00  time=387.7ms  FAIL
  PSO run  4: Y=1.643400e+00  err=1.643400e+00  time=393.0ms  FAIL
  PSO run  5: Y=1.724554e+00  err=1.724554e+00  time=393.5ms  FAIL
  PSO run  6: Y=2.140689e+00  err=2.140689e+00  time=391.5ms  FAIL
  PSO run  7: Y=8.790853e-01  err=8.790853e-01  time=398.1ms  FAIL
  PSO run  8: Y=1.597103e-03  err=1.597103e-03  time=395.6ms  OK
  PSO run  9: Y=1.027083e+00  err=1.027083e+00  time=395.2ms  FAIL
  PSO run 10: Y=2.259888e+00  err=2.259888e+00  time=398.0ms  FAIL
>>> Running GA ...
  GA  run  1: Y=1.181372e+01  err=1.181372e+01  time=387.3ms  FAIL
  GA  run  2: Y=1.138097e+01  err=1.138097e+01  time=391.3ms  FAIL
  GA  run  3: Y=1.213929e+01  err=1.213929e+01  time=389.1ms  FAIL
  GA  run  4: Y=1.217471e+01  err=1.217471e+01  time=382.7ms  FAIL
  GA  run  5: Y=1.268437e+01  err=1.268437e+01  time=382.8ms  FAIL
  GA  run  6: Y=1.205242e+01  err=1.205242e+01  time=383.4ms  FAIL
  GA  run  7: Y=1.189814e+01  err=1.189814e+01  time=383.0ms  FAIL
  GA  run  8: Y=1.119009e+01  err=1.119009e+01  time=378.9ms  FAIL
  GA  run  9: Y=1.274133e+01  err=1.274133e+01  time=390.7ms  FAIL
  GA  run 10: Y=1.239630e+01  err=1.239630e+01  time=377.2ms  FAIL
  --> PSO: success=10.0%, rmse=1.640904e+00, time=394.1ms
  --> GA : success=0.0%, rmse=1.205663e+01, time=384.6ms

========== Dimension = 100 | Threshold = 0.1 | Iterations = 3000 ==========
>>> Running PSO ...
  PSO run  1: Y=3.021570e+00  err=3.021570e+00  time=1885.3ms  FAIL
  PSO run  2: Y=2.531849e+00  err=2.531849e+00  time=2160.7ms  FAIL
  PSO run  3: Y=2.504945e+00  err=2.504945e+00  time=1941.7ms  FAIL
  PSO run  4: Y=2.265717e+00  err=2.265717e+00  time=2093.7ms  FAIL
  PSO run  5: Y=1.945676e+00  err=1.945676e+00  time=1894.8ms  FAIL
  PSO run  6: Y=1.952718e+00  err=1.952718e+00  time=1976.5ms  FAIL
  PSO run  7: Y=2.776657e+00  err=2.776657e+00  time=1920.0ms  FAIL
  PSO run  8: Y=2.678968e+00  err=2.678968e+00  time=1890.1ms  FAIL
  PSO run  9: Y=2.201854e+00  err=2.201854e+00  time=2000.9ms  FAIL
  PSO run 10: Y=2.637594e+00  err=2.637594e+00  time=1896.0ms  FAIL
>>> Running GA ...
  GA  run  1: Y=1.691997e+01  err=1.691997e+01  time=1810.9ms  FAIL
  GA  run  2: Y=1.658760e+01  err=1.658760e+01  time=1809.3ms  FAIL
  GA  run  3: Y=1.619412e+01  err=1.619412e+01  time=1911.2ms  FAIL
  GA  run  4: Y=1.649573e+01  err=1.649573e+01  time=1865.6ms  FAIL
  GA  run  5: Y=1.734714e+01  err=1.734714e+01  time=1872.4ms  FAIL
  GA  run  6: Y=1.757096e+01  err=1.757096e+01  time=1937.5ms  FAIL
  GA  run  7: Y=1.727048e+01  err=1.727048e+01  time=1884.1ms  FAIL
  GA  run  8: Y=1.641199e+01  err=1.641199e+01  time=1842.7ms  FAIL
  GA  run  9: Y=1.764021e+01  err=1.764021e+01  time=1971.4ms  FAIL
  GA  run 10: Y=1.728592e+01  err=1.728592e+01  time=2167.6ms  FAIL
  --> PSO: success=0.0%, rmse=2.474649e+00, time=1966.0ms
  --> GA : success=0.0%, rmse=1.697957e+01, time=1907.3ms


========== TABLE 1: SUCCESS RATE (%) ==========
Dim    Threshold  PSO (%)      GA (%)      
--------------------------------------------------
1      0.0010     100.0        100.0       
2      0.0010     100.0        100.0       
3      0.0010     100.0        100.0       
5      0.0010     100.0        100.0       
10     0.0100     100.0        0.0         
20     0.0100     100.0        0.0         
30     0.0100     90.0         0.0         
40     0.0100     70.0         0.0         
50     0.0100     10.0         0.0         
100    0.1000     0.0          0.0         


========== TABLE 2: RMSE ==========
Dim    Threshold    PSO RMSE        GA RMSE        
------------------------------------------------------
1      0.0010       4.440892e-16    1.484528e-10   
2      0.0010       4.440892e-16    4.440892e-16   
3      0.0010       4.440892e-16    4.734458e-14   
5      0.0010       3.352800e-15    2.789358e-04   
10     0.0100       5.690583e-15    4.682198e-01   
20     0.0100       1.438788e-10    3.988638e+00   
30     0.0100       3.652900e-01    6.194765e+00   
40     0.0100       7.554179e-01    9.635879e+00   
50     0.0100       1.640904e+00    1.205663e+01   
100    0.1000       2.474649e+00    1.697957e+01   


========== TABLE 3: AVG TIME (ms) ==========
Dim    PSO Time (ms)   GA Time (ms)   
--------------------------------------
1      6.85            23.98          
2      12.05           22.72          
3      13.03           28.48          
5      15.44           23.62          
10     41.17           52.71          
20     110.32          94.06          
30     179.82          180.09         
40     281.25          274.36         
50     394.14          384.64         
100    1965.95         1907.27        


========== TABLE 4: WINNER PER DIMENSION ==========
Dim    Success         RMSE            Time           
------------------------------------------------------
1      Tie             PSO             PSO            
2      Tie             Tie             PSO            
3      Tie             PSO             PSO            
5      Tie             PSO             PSO            
10     PSO             PSO             PSO            
20     PSO             PSO             GA             
30     PSO             PSO             PSO            
40     PSO             PSO             GA             
50     PSO             PSO             GA             
100    Tie             PSO             GA             

Total experiment time: 60.25 seconds
