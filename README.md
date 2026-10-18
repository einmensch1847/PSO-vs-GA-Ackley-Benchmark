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
========== TABLE 2: RMSE ==========
Dim    Threshold    PSO RMSE        GA RMSE        
------------------------------------------------------
...
100    0.1000       2.474649e+00    1.697957e+01   
...
