# MPAndroidChartDemo

###1.常用设置
    mChart.setDescription("");    //设置图表描述信息
		mChart.setScaleEnabled(false); //设置图表是否可缩放
		mChart.setBackgroundColor(Color.WHITE); //设置图表背景颜色
		mChart.setDrawGridBackground(false);  //设置是否显示表格

		XAxis xAxis = mChart.getXAxis();     //得到图表的X轴实例
		xAxis.setPosition(XAxisPosition.BOTTOM);//设置X轴的显示位置
		xAxis.setDrawGridLines(false);  //设置是否显示X轴表格
		xAxis.setAvoidFirstLastClipping(true); //设置x轴起点和终点label不超出屏幕
		xAxis.setDrawAxisLine(true);           //设置显示x轴
		xAxis.setSpaceBetweenLabels(0); // 设置x轴label不间隔

		YAxis leftAxis = mChart.getAxisLeft();  //得到图表的左侧Y轴实例
		leftAxis.setAxisMaxValue(3.4482f); // 设置Y轴最大值
		leftAxis.setAxisMinValue(3.1872f);// 设置Y轴最小值。
		leftAxis.setStartAtZero(false);   //设置图表起点从0开始
		leftAxis.enableGridDashedLine(10f, 10f, 0f); //设置横向表格为虚线
    mChart.getAxisRight().setEnabled(false); //设置右侧Y轴不可用（这里可以向得到左侧Y轴那样，得到右侧Y轴实例去处理）
