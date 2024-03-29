import axios from "axios";
import React, { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess } from "../../Types/sale";
import { round } from "../../utils/format";
import { BASE_URL } from "../../utils/Requests";

type  SeriesData = {
  name: string;
  data: number[];
}

type ChartData = {
  labels: {
    categories: string[];
  }
  series: SeriesData[];
}

function BarChart() {
  
  const [chartData, setChartData] = useState<ChartData>(
    {
      labels: {
        categories: []
      },
      series: [
        {
          name: "",
          data: []
        }
      ]
    }
  );
  
  useEffect(() => {
    axios.get(`${ BASE_URL }/sales/success-by-seller`)
    .then((response) => {
      const data = response.data as SaleSuccess[];
      const myLabels = data.map(e => e.sellerName);
      const mySeries = data.map(e => round(100 * e.deals / e.visited, 1));
      
      setChartData({
        labels: {
          categories: myLabels
        },
        series: [
          {
            name: "% Sucesso",
            data: mySeries
          }
        ]
      });
    });
  }, []);
  
  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };
  
  return (
    <Chart
      options={ { ...options, xaxis: chartData.labels } }
      series={ chartData.series }
      type="bar"
      height="240"
    />
  );
}

export default BarChart;
