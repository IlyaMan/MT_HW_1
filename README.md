# Подсчет среднего в мультиагентной сети (JADE)

## Описание алгоритма
### Вводные
Агенты объединены в сеть, представляющую собой связный ненаправленный граф.

Каждый агент обладает информацией обо всех других подключенных к нему агентах и о своем загаданном числе.

### Алгоритм
0. Агент добавляет в свою таблицу информацию о своем загаданном числе.
1. Агент отправляет всем своим соседям свою таблицу.
2. Агент принимает от всех своих соседей их таблицы и обновляет свою новой информацией.
3. Как только агент перестает получать новую информацию (два раза подряд получает таблицы без изменений), 
он останавливает выполнение. Если агент -- младший по номеру, он отправляет информацию в центр (println).
Если нет, он просто останавливается.

## Оценки алгоритма
- Память: `2n` на агента, `2n*n` на сеть агентов
- Локальные коммуникации: `n*n`
- Операции: `n*n`
- Коммуникации с центром: 1

# Тестовые параметры запуска
Связная сеть из 100 агентов

`-agents 0:MTAgent(9,10.50.120.130.140.150.160.200.210.250.260.270.290.300.310.350.360.370.380.390.400.420.480.490.500.510.530.580.610.630.640.650.670.680.690.730.750.780.800.810.850.860.870.890.910.950);10:MTAgent(10,0.80.90.100.110.120.150.180.210.240.260.270.280.300.310.320.350.380.410.420.430.470.490.590.600.610.620.640.680.710.750.760.770.780.790.800.810.820.840.850.870.890.910.940);20:MTAgent(7,30.40.50.70.80.110.150.170.200.220.230.240.260.280.290.300.310.330.360.370.390.400.440.450.470.540.560.580.600.620.640.650.670.680.690.710.730.740.790.840.870.920.960.970.980);30:MTAgent(7,20.40.50.70.80.90.110.140.220.230.240.260.270.280.300.310.320.340.380.390.400.410.420.450.470.480.490.500.600.610.620.630.650.670.710.720.750.770.790.840.860.920.940.950.960.980.990);40:MTAgent(6,20.30.60.150.170.180.200.210.240.250.260.280.310.320.340.360.370.400.420.430.440.460.470.480.520.540.550.590.600.610.630.660.690.710.750.770.800.810.820.830.840.850.860.870.880.890.960.980);50:MTAgent(2,0.20.30.60.100.120.150.160.190.200.220.260.270.280.310.320.360.380.390.400.420.460.490.500.530.540.570.580.650.690.700.710.720.730.750.760.790.800.820.830.850.860.870.900.910.930.980.990);60:MTAgent(10,40.50.80.100.110.160.180.200.210.230.240.250.290.300.340.350.360.370.400.410.430.440.450.460.480.500.520.540.550.560.570.600.610.620.630.670.710.750.760.780.810.820.850.870.890.900.910.940.960);70:MTAgent(1,20.30.80.110.120.140.180.200.210.220.240.260.270.280.290.300.310.330.340.350.360.390.410.450.490.500.510.550.580.610.630.650.660.690.700.720.740.760.770.780.790.800.820.830.840.860.870.890.900.910.930.950.960.970.990);80:MTAgent(3,10.20.30.60.70.100.120.130.140.160.180.210.220.270.280.340.350.360.380.400.420.430.450.470.500.510.540.560.580.600.610.620.640.660.670.680.690.700.740.760.790.810.840.850.860.870.880.910.930.950.990);90:MTAgent(10,10.30.110.120.130.170.180.190.200.220.230.240.250.270.280.310.320.330.340.350.370.440.480.490.500.530.550.560.590.600.650.670.680.690.700.730.790.800.840.910.930.940.960.990);100:MTAgent(8,10.50.60.80.120.150.160.180.190.220.230.240.270.280.310.320.340.360.380.390.410.430.450.490.500.520.550.570.610.620.640.680.690.760.770.780.810.840.860.880.900.910.920.930.940.960.980.990);110:MTAgent(3,10.20.30.60.70.90.120.150.180.190.220.230.240.250.270.280.290.320.330.340.370.390.410.430.440.470.480.520.530.540.550.560.590.610.620.630.640.670.680.700.710.720.750.790.820.840.850.880.900.910.930.940.970.980.990);120:MTAgent(8,0.10.50.70.80.90.100.110.130.140.170.200.230.250.260.280.290.310.320.360.370.400.430.440.460.470.490.500.520.540.550.560.570.600.610.640.710.730.750.790.830.850.860.880.910.920.950.990);130:MTAgent(2,0.80.90.120.140.150.190.200.210.220.240.300.320.330.340.350.390.400.420.480.560.590.600.620.630.660.670.710.740.750.790.860.870.890.900.910.920.930.940.970.980);140:MTAgent(9,0.30.70.80.120.130.160.170.190.200.210.260.300.320.350.380.390.400.410.420.430.440.460.480.500.510.530.540.550.570.590.600.660.700.740.760.790.800.820.830.840.860.900.920.940.960.970.990);150:MTAgent(2,0.10.20.40.50.100.110.130.170.200.210.220.230.240.270.280.310.330.340.370.390.430.440.450.460.480.490.500.510.560.570.600.620.630.690.730.740.760.790.820.830.870.880.890.900.910.920.940.960.970);160:MTAgent(3,0.50.60.80.100.140.170.190.200.240.260.300.310.330.340.350.370.380.420.470.480.510.520.530.550.560.570.580.590.600.630.660.670.690.700.720.750.760.820.830.840.870.880.930.950.960.970);170:MTAgent(6,20.40.90.120.140.150.160.190.200.210.240.250.280.340.360.370.380.410.420.430.440.450.460.470.500.540.550.570.580.590.600.620.630.660.670.690.720.740.780.850.870.900.930.940.950.960.970.990);180:MTAgent(10,10.40.60.70.80.90.100.110.190.200.210.250.260.270.310.320.350.360.390.420.430.460.470.490.500.520.550.560.570.620.630.640.660.680.710.720.730.750.760.770.800.810.830.850.940.960.990);190:MTAgent(5,50.90.100.110.130.140.160.170.180.200.210.220.230.280.300.310.330.340.350.360.390.400.410.420.430.440.450.470.490.500.510.530.570.580.590.600.610.630.640.680.700.710.720.730.750.770.810.820.840.850.860.870.890.950.960.990);200:MTAgent(5,0.20.40.50.60.70.90.120.130.140.150.160.170.180.190.210.230.240.250.270.280.290.310.340.350.360.410.450.470.490.500.510.520.530.540.550.560.600.610.630.650.660.670.680.690.700.730.740.750.760.780.790.800.810.850.860.890.900.910.920.940.970.990);210:MTAgent(3,0.10.40.60.70.80.130.140.150.170.180.190.200.220.230.250.300.320.330.350.360.370.430.480.500.510.520.530.570.580.590.610.620.630.640.660.670.680.690.700.720.740.760.770.780.790.870.880.910.920.930.940.980.990);220:MTAgent(5,20.30.50.70.80.90.100.110.130.150.190.210.230.260.290.310.320.350.360.390.400.410.440.490.500.520.530.540.550.560.580.590.610.640.650.720.740.750.760.830.840.860.890.900.930.940.950.960.980);230:MTAgent(1,20.30.60.90.100.110.120.150.190.200.210.220.260.270.280.290.310.340.370.380.390.410.430.440.470.480.520.530.540.550.560.570.580.610.640.650.680.700.720.740.750.760.790.800.840.850.880.890.900.910.930.940.970.990);240:MTAgent(4,10.20.30.40.60.70.90.100.110.130.150.160.170.200.320.340.350.370.390.400.420.430.470.480.520.540.550.580.620.630.640.650.660.720.740.750.760.770.780.790.800.810.830.840.860.880.940.950.960.970.980.990);250:MTAgent(5,0.40.60.90.110.120.170.180.200.210.260.280.290.300.310.320.330.440.460.470.490.520.540.560.570.630.670.680.700.710.720.730.740.760.790.810.840.850.880.900.910.920.930.960);260:MTAgent(2,0.10.20.30.40.50.70.120.140.160.180.220.230.250.280.320.340.350.390.420.430.440.450.460.470.500.510.520.590.610.630.640.650.660.670.700.730.760.770.790.810.830.860.910.920.930.940.980);270:MTAgent(4,0.10.30.50.70.80.90.100.110.150.180.200.230.290.310.320.330.340.370.380.390.420.440.450.460.470.490.520.580.640.650.670.690.710.720.770.780.810.820.870.880.900.910.930.960.970.990);280:MTAgent(5,10.20.30.40.50.70.80.90.100.110.120.150.170.190.200.230.250.260.290.330.340.360.400.410.430.480.510.520.530.570.590.600.620.650.680.710.720.750.760.770.780.790.800.820.860.870.880.890.900.910.940.950.980.990);290:MTAgent(8,0.20.60.70.110.120.200.220.230.250.270.280.300.350.360.390.400.430.450.470.500.520.530.580.600.640.650.680.710.720.730.740.750.760.770.780.790.800.830.840.860.870.880.900.910.920.960.990);300:MTAgent(7,0.10.20.30.60.70.130.140.160.190.210.250.290.310.320.330.360.370.400.430.440.450.460.510.520.540.550.560.580.590.600.610.650.700.710.720.740.750.770.780.810.820.830.850.890.930.960.970.980);310:MTAgent(10,0.10.20.30.40.50.70.90.100.120.150.160.180.190.200.220.230.250.270.300.320.330.340.370.380.390.400.430.440.450.470.500.510.540.550.560.570.590.620.630.680.690.730.760.800.810.850.860.870.890.920.950.990);320:MTAgent(9,10.30.40.50.90.100.110.120.130.140.180.210.220.240.250.260.270.300.310.350.440.460.490.500.550.560.570.590.650.690.700.720.740.770.820.830.860.880.890.900.910.930.970.990);330:MTAgent(6,20.70.90.110.130.150.160.190.210.250.270.280.300.310.350.370.380.390.430.440.450.480.490.500.540.550.560.580.590.600.630.650.660.670.680.690.700.720.730.740.750.770.800.810.860.880.910.940.950.960.970);340:MTAgent(8,30.40.60.70.80.90.100.110.130.150.160.170.190.200.230.240.260.270.280.310.350.380.390.400.420.430.450.460.470.510.530.560.610.660.680.690.710.730.740.760.780.820.870.900.910.920.930.940.960.980.990);350:MTAgent(6,0.10.60.70.80.90.130.140.160.180.190.200.210.220.240.260.290.320.330.340.380.410.420.430.440.450.460.480.510.520.530.550.570.580.590.620.630.650.670.710.720.730.740.750.800.810.870.920.930.980);360:MTAgent(2,0.20.40.50.60.70.80.100.120.170.180.190.200.210.220.280.290.300.370.380.400.410.420.430.440.480.490.510.520.550.560.620.660.670.690.740.750.810.830.840.860.880.890.920.930.950.960.980.990);370:MTAgent(10,0.20.40.60.90.110.120.150.160.170.210.230.240.270.300.310.330.360.390.400.420.430.450.480.520.530.540.560.570.580.590.600.610.620.670.680.690.700.720.770.790.810.850.860.910.930.940.970.980.990);380:MTAgent(9,0.10.30.50.80.100.140.160.170.230.270.310.330.340.350.360.390.400.420.430.460.470.490.520.570.580.640.710.730.740.750.760.770.800.820.830.840.860.870.880.890.900.910.960.990);390:MTAgent(9,0.20.30.50.70.100.110.130.140.150.180.190.220.230.240.260.270.290.310.330.340.370.380.400.430.470.480.510.520.540.590.610.620.630.640.680.700.720.740.770.780.820.830.840.850.860.880.900.920.940.950.960.980);400:MTAgent(8,0.20.30.40.50.60.80.120.130.140.190.220.240.280.290.300.310.340.360.370.380.390.450.460.480.490.500.580.600.640.660.690.700.730.760.780.800.810.820.850.860.890.900.910.940.950.960.990);410:MTAgent(10,10.30.60.70.100.110.140.170.190.200.220.230.280.350.360.420.430.460.470.480.540.550.570.580.600.630.680.710.730.760.780.800.820.840.860.870.880.890.900.910.920.930.980);420:MTAgent(4,0.10.30.40.50.80.130.140.160.170.180.190.240.260.270.340.350.360.370.380.410.430.450.460.470.480.500.510.590.640.670.690.730.740.760.770.790.850.870.880.890.900.910.920.950.970.990);430:MTAgent(1,10.40.60.80.100.110.120.140.150.170.180.190.210.230.240.260.280.290.300.310.330.340.350.360.370.380.390.410.420.490.500.510.520.550.560.570.660.670.700.730.740.750.770.790.810.830.850.880.900.910.920.930.960.970.990);440:MTAgent(7,20.40.60.90.110.120.140.150.170.190.220.230.250.260.270.300.310.320.330.350.360.450.460.470.520.530.550.610.620.630.640.650.670.700.710.720.740.770.800.820.870.880.910.920.950.960.980.990);450:MTAgent(1,20.30.60.70.80.100.150.170.190.200.260.270.290.300.310.330.340.350.370.400.420.440.460.480.490.500.510.530.570.580.590.620.630.640.650.660.670.710.730.760.780.800.810.820.840.850.880.920.940.950);460:MTAgent(3,40.50.60.120.140.150.170.180.250.260.270.300.320.340.350.380.400.410.420.440.450.470.480.520.540.560.580.590.610.620.640.650.670.680.690.700.710.720.750.780.790.810.830.860.890.910.960.980.990);470:MTAgent(3,10.20.30.40.80.110.120.160.170.180.190.200.230.240.250.260.270.290.310.340.380.390.410.420.440.460.490.530.540.580.600.610.620.670.690.710.730.740.750.760.790.800.820.830.870.880.900.920.930.940.950.960.970.990);480:MTAgent(4,0.30.40.60.90.110.130.140.150.160.210.230.240.280.330.350.360.370.390.400.410.420.450.460.490.500.570.610.620.640.650.660.680.700.720.750.780.800.810.820.830.870.880.940.960.970.980);490:MTAgent(2,0.10.30.50.70.90.100.120.150.180.190.200.220.250.270.320.330.360.380.400.430.450.470.480.510.530.540.550.560.580.640.660.670.740.760.770.790.800.810.820.840.850.860.870.880.900.940.950.960);500:MTAgent(4,0.30.50.60.70.80.90.100.120.140.150.170.180.190.200.210.220.260.290.310.320.330.400.420.430.450.480.520.540.560.570.590.600.610.620.630.650.660.680.690.700.710.740.760.770.780.790.800.820.840.850.880.890.900.960.970);510:MTAgent(9,0.70.80.140.150.160.190.200.210.260.280.300.310.340.350.360.390.420.430.450.490.520.560.570.600.610.630.640.650.680.700.720.750.760.830.850.860.880.950.960.970.990);520:MTAgent(8,40.60.100.110.120.160.180.200.210.220.230.240.250.260.270.280.290.300.350.360.370.380.390.430.440.460.500.510.560.570.650.660.670.680.690.710.730.740.750.760.780.790.800.880.900.910.920.930.950.960.970);530:MTAgent(8,0.50.90.110.140.160.190.200.210.220.230.280.290.340.350.370.440.450.470.490.560.610.620.630.640.650.660.670.700.710.730.750.760.780.790.810.830.870.880.930.940.950.970.990);540:MTAgent(8,20.40.50.60.80.110.120.140.170.200.220.230.240.250.300.310.330.370.390.410.460.470.490.500.580.600.620.630.650.690.710.720.740.760.780.800.820.840.850.860.880.910.920.930.970.980.990);550:MTAgent(9,40.60.70.90.100.110.120.140.160.170.180.200.220.230.240.300.310.320.330.350.360.410.430.440.490.570.590.610.620.630.650.660.670.680.690.700.760.780.790.800.820.840.850.860.880.910.920.930.940.950.960.970.980.990);560:MTAgent(8,20.60.80.90.110.120.130.150.160.180.200.220.230.250.300.310.320.330.340.360.370.430.460.490.500.510.520.530.580.590.610.640.680.690.700.710.720.760.770.780.790.810.830.860.870.910.920.940.950);570:MTAgent(6,50.60.100.120.140.150.160.170.180.190.210.230.250.280.310.320.350.370.380.410.430.450.480.500.510.520.550.600.610.630.640.650.660.760.790.810.820.840.870.880.890.910.920.950.970.980.990);580:MTAgent(9,0.20.50.70.80.160.170.190.210.220.230.240.270.290.300.330.350.370.380.400.410.450.460.470.490.540.560.630.640.660.700.730.760.810.820.840.870.880.900.920.950.970);590:MTAgent(5,10.40.90.110.130.140.160.170.190.210.220.260.280.300.310.320.330.350.370.390.420.450.460.500.550.560.610.630.640.660.680.690.730.740.750.760.780.790.800.820.830.870.890.900.910.940.960.990);600:MTAgent(8,10.20.30.40.60.80.90.120.130.140.150.160.170.190.200.280.290.300.330.370.400.410.470.500.510.540.570.610.630.650.670.700.720.730.740.760.770.790.800.810.830.840.850.860.870.880.890.910.920.950.960.970.980);610:MTAgent(6,0.10.30.40.60.70.80.100.110.120.190.200.210.220.230.260.300.340.370.390.440.460.470.480.500.510.530.550.560.570.590.600.650.710.730.770.780.790.810.820.830.850.860.870.880.890.930.950.960.980.990);620:MTAgent(1,10.20.30.60.80.100.110.130.150.170.180.210.240.280.310.350.360.370.390.440.450.460.470.480.500.530.540.550.630.680.690.700.740.770.780.790.800.810.820.840.870.890.930.950.960.970);630:MTAgent(1,0.30.40.60.70.110.130.150.160.170.180.190.200.210.240.250.260.310.330.350.390.410.440.450.500.510.530.540.550.570.580.590.600.620.650.680.690.700.710.730.750.760.770.780.800.820.840.850.890.950.960.980.990);640:MTAgent(10,0.10.20.80.100.110.120.180.190.210.220.230.240.260.270.290.380.390.400.420.440.450.460.480.490.510.530.560.570.580.590.650.720.730.740.750.760.800.850.860.870.900.920.930.980.990);650:MTAgent(7,0.20.30.50.70.90.200.220.230.240.260.270.280.290.300.320.330.350.440.450.460.480.500.510.520.530.540.550.570.600.610.630.640.690.700.740.750.780.790.800.830.860.910.920.930.940.950);660:MTAgent(5,40.70.80.130.140.160.170.180.200.210.240.260.330.340.360.400.430.450.480.490.500.520.530.550.570.580.590.670.680.690.700.710.720.730.760.770.790.800.830.840.850.860.890.900.920.940.950.960);670:MTAgent(5,0.20.30.60.80.90.110.130.160.170.200.210.250.260.270.330.350.360.370.420.430.440.450.460.470.490.520.530.550.600.660.690.730.740.750.790.810.840.850.860.870.890.920.940.960.980.990);680:MTAgent(2,0.10.20.80.90.100.110.180.190.200.210.230.250.280.290.310.330.340.370.390.410.460.480.500.510.520.550.560.590.620.630.660.700.710.720.750.760.780.790.800.820.830.840.870.900.940.950.960.990);690:MTAgent(1,0.20.40.50.70.80.90.100.150.160.170.200.210.270.310.320.330.340.360.370.400.420.460.470.500.520.540.550.560.590.620.630.650.660.670.730.750.780.790.800.820.830.840.850.870.880.890.940.950.960.970);700:MTAgent(2,50.70.80.90.110.140.160.190.200.210.230.250.260.300.320.330.370.390.400.430.440.460.480.500.510.530.550.560.580.600.620.630.650.660.680.710.720.810.830.840.850.860.910.930.940.950.960.980.990);710:MTAgent(4,10.20.30.40.50.60.110.120.130.180.190.250.270.280.290.300.340.350.380.410.440.450.460.470.500.520.530.540.560.610.630.660.680.700.720.730.750.760.780.790.800.830.840.860.870.910.980.990);720:MTAgent(6,30.50.70.110.160.170.180.190.210.220.230.240.250.270.280.290.300.320.330.350.370.390.440.460.480.510.540.560.600.640.660.680.700.710.730.740.780.790.810.820.840.850.860.880.900.910.920.990);730:MTAgent(6,0.20.50.90.120.150.180.190.200.250.260.290.310.330.340.350.380.400.410.420.430.450.470.520.530.580.590.600.610.630.640.660.670.690.710.720.740.750.800.810.820.830.840.850.860.890.900.910.930.940.950.960.970.980);740:MTAgent(6,20.70.80.130.140.150.170.200.210.220.230.240.250.290.300.320.330.340.350.360.380.390.420.430.440.470.490.500.520.540.590.600.620.640.650.670.720.730.750.760.800.810.860.880.890.910.920);750:MTAgent(6,0.10.30.40.50.60.110.120.130.160.180.190.200.220.230.240.280.290.300.330.350.360.380.430.460.470.480.510.520.530.590.630.640.650.670.680.690.710.730.740.760.790.800.810.830.840.860.920.930.960.980.990);760:MTAgent(6,10.50.60.70.80.100.140.150.160.180.200.210.220.230.240.250.260.280.290.310.340.380.400.410.420.450.470.490.500.510.520.530.540.550.560.570.580.590.600.630.640.660.680.710.740.750.790.810.820.840.850.860.900.950.960.970.990);770:MTAgent(4,10.30.40.70.100.180.190.210.240.260.270.280.290.300.320.330.370.380.390.420.430.440.490.500.560.600.610.620.630.660.780.800.810.820.840.860.870.880.900.920.930.940.950.980.990);780:MTAgent(3,0.10.60.70.100.170.200.210.240.270.280.290.300.340.390.400.410.450.460.480.500.520.530.540.550.560.590.610.620.630.650.680.690.710.720.770.810.820.910.960.970.980.990);790:MTAgent(9,10.20.30.50.70.80.90.110.120.130.140.150.200.210.230.240.250.260.280.290.370.420.430.460.470.490.500.520.530.550.560.570.590.600.610.620.650.660.670.680.690.710.720.750.760.800.810.850.880.900.910.920.950.960.980);800:MTAgent(1,0.10.40.50.70.90.140.180.200.230.240.280.290.310.330.350.380.400.410.440.450.470.480.490.500.520.540.550.590.600.620.630.640.650.660.680.690.710.730.740.750.770.790.850.860.880.890.910.950);810:MTAgent(7,0.10.40.60.80.100.180.190.200.240.250.260.270.300.310.330.350.360.370.400.430.450.460.480.490.530.560.570.580.600.610.620.670.700.720.730.740.750.760.770.780.790.820.860.870.890.900.920.930.940.960.970.990);820:MTAgent(5,10.40.50.60.70.110.140.150.160.190.270.280.300.320.340.380.390.400.410.440.450.470.480.490.500.540.550.570.580.590.610.620.630.680.690.720.730.760.770.780.810.880.950.970.980);830:MTAgent(3,40.50.70.120.140.150.160.180.220.240.260.290.300.320.360.380.390.430.460.470.480.510.530.560.590.600.610.650.660.680.690.700.710.730.750.840.850.890.910.920.930.950.970.980.990);840:MTAgent(6,10.20.30.40.70.80.90.100.110.140.160.190.220.230.240.250.290.360.380.390.410.450.490.500.540.550.570.580.600.620.630.660.670.680.690.700.710.720.730.750.760.770.830.870.890.900.920.930.960.970);850:MTAgent(2,0.10.40.50.60.80.110.120.170.180.190.200.230.250.300.310.370.390.400.420.430.450.490.500.510.540.550.600.610.630.640.660.670.690.700.720.730.760.790.800.830.860.880.890.900.920.940.950.960.970.980.990);860:MTAgent(8,0.30.40.50.70.80.100.120.130.140.190.200.220.240.260.280.290.310.320.330.360.370.380.390.400.410.460.490.510.540.550.560.600.610.640.650.660.670.700.710.720.730.740.750.760.770.800.810.850.870.900.910.920.930.940.970.980);870:MTAgent(2,0.10.20.40.50.60.70.80.130.150.160.170.190.210.270.280.290.310.340.350.380.410.420.440.470.480.490.530.560.570.580.590.600.610.620.640.670.680.690.710.770.810.840.860.910.980);880:MTAgent(10,40.80.100.110.120.150.160.210.230.240.250.270.280.290.320.330.360.380.390.410.420.430.440.450.470.480.490.500.510.520.530.540.550.570.580.600.610.690.720.740.770.790.800.820.850.890.930.950.970.980.990);890:MTAgent(8,0.10.40.60.70.130.150.190.200.220.230.280.300.310.320.360.380.400.410.420.460.500.570.590.600.610.620.630.660.670.690.730.740.800.810.830.840.850.880.900.920.940.960.970.980);900:MTAgent(3,50.60.70.100.110.130.140.150.170.200.220.230.250.270.280.290.320.340.380.390.400.410.420.430.470.490.500.520.580.590.640.660.680.720.730.760.770.790.810.840.850.860.890.930.960.970.980);910:MTAgent(2,0.10.50.60.70.80.90.100.110.120.130.150.200.210.230.250.260.270.280.290.320.330.340.370.380.400.410.420.430.440.460.520.540.550.560.570.590.600.650.700.710.720.730.740.780.790.800.830.860.870.930.940.980);920:MTAgent(10,20.30.100.120.130.140.150.200.210.250.260.290.310.340.350.360.390.410.420.430.440.450.470.520.540.550.560.570.580.600.640.650.660.670.720.740.750.770.790.810.830.840.850.860.890.930.940.950);930:MTAgent(5,50.70.80.90.100.110.130.160.170.210.220.230.250.260.270.300.320.340.350.360.370.410.430.470.520.530.540.550.610.620.640.650.700.730.750.770.810.830.840.860.880.900.910.920.960.990);940:MTAgent(1,10.30.60.90.100.110.130.140.150.170.180.200.210.220.230.240.260.280.330.340.370.390.400.450.470.480.490.530.550.560.590.650.660.670.680.690.700.730.770.810.850.860.890.910.920.950.960.980.990);950:MTAgent(10,0.30.70.80.120.160.170.190.220.240.280.310.330.360.390.400.420.440.450.470.490.510.520.530.550.560.570.580.600.610.620.630.650.660.680.690.700.730.760.770.790.800.820.830.850.880.920.940.960.980);960:MTAgent(1,20.30.40.60.70.90.100.140.150.160.170.180.190.220.240.250.270.290.300.330.340.360.380.390.400.430.440.460.470.480.490.500.510.520.550.590.600.610.620.630.660.670.680.690.700.730.750.760.780.790.810.840.850.890.900.930.940.950.990);970:MTAgent(3,20.70.110.130.140.150.160.170.200.230.240.270.300.320.330.370.420.430.470.480.500.510.520.530.540.550.570.580.600.620.690.730.760.780.810.820.830.840.850.860.880.890.900.990);980:MTAgent(6,20.30.40.50.100.110.130.210.220.240.260.280.300.340.350.360.370.390.410.440.460.480.540.550.570.600.610.630.640.670.700.710.730.750.770.780.790.820.830.850.860.870.880.890.900.910.940.950);990:MTAgent(9,30.50.70.80.90.100.110.120.140.170.180.190.200.210.230.240.270.280.290.310.320.340.360.370.380.400.420.430.440.460.470.510.530.540.550.570.590.610.630.640.670.680.700.710.720.750.760.770.780.810.830.850.880.930.940.960.970)`
Ожидаемый вывод:
`Average: 5.56`