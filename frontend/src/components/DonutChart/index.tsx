import axios from "axios";
import React from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from "../../Types/sail";
import { BASE_URL } from "../../utils/Requests";

type ChartData = {
  labels: string[];
  series: number[];
}

function DonutChart() {
  
  let chartData: ChartData = { labels: [], series: [] };
  
  axios.get(`${ BASE_URL }/sales/amount-by-seller`)
  .then((response) => {
    const data = response.data as SaleSum[];
    const myLabels = data.map(e => e.sellerName);
    const mySeries = data.map(e => e.sum);
    
    chartData = { labels: myLabels, series: mySeries };
    
    
    console.log(chartData);
  });
  
  const mockData = {
    series: [477138, 499928, 444867, 220426, 473088],
    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  };
  
  const options = {
    legend: {
      show: true
    }
  };
  
  return (
    <Chart
      options={ { ...options, labels: mockData.labels } }
      series={ mockData.series }
      type="donut"
      height="240"
    />
  );
}

export default DonutChart;
