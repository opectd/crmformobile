$(function () {
    $('#chart1').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
           /* width:420,
            height:200,*/
            x:400

        },
        title: {
            text: null
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        credits:{
            enabled:false
        },
        legend:{
            layout:'vertical',
            floating:true,
            align:'left',
            y:-50,
            x:-20
        },
        series: [{
            type: 'pie',
            name: '本月跟进订单统计分析',
            data: [
                ['跟进中订单',       25],
                ['约量尺订单',    30],
                ['已量尺订单',     20],
                ['已签合同未审核订单',   25]
            ]
        }]
    });
 $('#chart2').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            width:400,
            height:200,
            x:300

        },
        title: {
            text: null
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        credits:{
            enabled:false
        },
        legend:{
            layout:'vertical',
            floating:true,
            align:'left',
            y:-50,
            x:-10
        },
        series: [{
            type: 'pie',
            name: '本月跟该设计师的合作统计分析',
            data: [
                ['木门',       25],
                ['橱柜',    30],
                ['衣柜',     20],
                ['卫浴',   25]
            ]
        }]
    });
$('#chart3').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
           /* width:400,
            height:200,*/
            x:300
        },
        title: {
            text: null
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        credits:{
            enabled:false
        },
        legend:{
            layout:'vertical',
           
            align:'left',
            y:-50,
            x:-20,
            itemStyle:{fontSize:'10px',lineHeight:80},
          
        },
        series: [{
            type: 'pie',
            name: '本月未成交订单统计分析',
            data: [
                ['跟进中订单',       25],
                ['约量尺订单',    30],
                ['已量尺订单',     20],
                ['已签合同未审核订单',   25]
            ]
        }]
    });
     $('#chart4').highcharts({
        chart: {
            type: 'column',
           /* width:300,
            height:200,*/
            x:200
        },
        title: {
            text: null
        },
        xAxis: {
            categories: [
                '原因一',
                '原因二',
                '原因三',
                '原因四',
                '原因五'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '个'
            }
        },
        credits:{
            enabled:false
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} 个</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '本季度',
            data: [10, 12, 6 , 16, 3]
        }, {
            name: '上季度',
            data: [13, 15, 8 , 6, 13]
        }]
    });
    


    var gaugeOptions = {
        chart: {
            type: 'solidgauge',
           /* width:160,
            height:100,*/
            backgroundColor:'#f39800',
            marginTop:36,
            marginLeft:-40
        },
        title: null,
        pane: {
            center: ['60%', '55%'],
            size: '140%',
            startAngle: -124,
            endAngle: 124,
            background: {
                innerRadius: '86%',
                outerRadius: '100%',
                shape: 'arc'
            },

        },
        tooltip: {
            enabled: false
        },
        yAxis: {
            stops: [
                [0.1, '#55BF3B'], // green
                [0.2, '#DDDF0D'], // yellow
                [0.5, '#DF5353'] // red
            ],
            lineWidth: 0,
            minorTickInterval: null,
            tickPixelInterval: 400,
            tickWidth: 0,
            title: {
                y: -20
            },
            labels: {
                y: 22,
            }
        },
        plotOptions: {
            solidgauge: {
                dataLabels: {
                    y: 26,
                    x:-4,
                    borderWidth: 0,
                    useHTML: true,
                    color:'#ff0000',

                }
            }
        }
    };
    $('#chart5').highcharts(Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: 200,
            title: {
                text: null
            }
        },
        credits: {
            enabled: false
        },
        series: [{
            name: '订单',
            data: [30],
            innerRadius:'86%',
            dataLabels: {
                format: '<span style="font-size:20px;color:#ff0000;left:-20px;top:14px;">{y}单</span>'
            },
        }]
    }));
     $('#chart6').highcharts(Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: 200,
            title: {
                text: null
            }
        },
        credits: {
            enabled: false
        },
        series: [{
            name: '订单',
            data: [30],
            innerRadius:'86%',
            dataLabels: {
                format: '<span style="font-size:12px;color:#ff0000;left:-30px;top:14px;">未处理{y}单</span>'
            },
        }]
    }));
 /*   var chart = $('#chart5').highcharts();
    chart.reflow();*/
   
  /*  // Bring life to the dials
    setInterval(function () {
        // Speed
        var chart = $('#chart5').highcharts(),
            point,
            newVal,
            inc;
        if (chart) {
            point = chart.series[0].points[0];
            inc = Math.round((Math.random() - 0.5) * 100);
            newVal = point.y + inc;
            if (newVal < 0 || newVal > 200) {
                newVal = point.y - inc;
            }
            point.update(newVal);
        }
        
});*/

});
