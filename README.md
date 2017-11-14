# MPAndroidChartDemo

MPAndroidChart 教程:http://blog.csdn.net/u014136472/article/details/50273309

1.常用设置

		mChart.setDrawGridBackground(false);  //设置是否显示表格
        mChart.setDescription("");    //设置图表描述信息
        mChart.getDescription().setEnabled(false); // 设置描述信息是否可用

        // 设置MarkerView
        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv); // Set the marker to the chart

        // 设置一条限制线
        LimitLine llXAxis = new LimitLine(10f, "Index 10");// 位置， 名称
        llXAxis.setLineWidth(4f); // 限制线的高
        llXAxis.enableDashedLine(10f, 10f, 0f);// 线的样式设置为虚线样式,三个参数分别是（长度，间距，没太看懂）
        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);// 设置线名称相对于线的位置
        llXAxis.setTextSize(10f);// 线名称的字号
        llXAxis.setTypeface(tf);// 线名称字体样式


2.图表的交互

        mChart.setTouchEnabled(true); // 设置是否可以触摸
        mChart.setDragEnabled(true);// 是否可以拖拽
        mChart.setScaleEnabled(true);// 是否可以缩放 x和y轴, 默认是true
        mChart.setScaleXEnabled(true); //是否可以缩放 仅x轴
        mChart.setScaleYEnabled(true); //是否可以缩放 仅y轴
        lineChart.setPinchZoom(true);  //设置x轴和y轴能否同时缩放。默认是否




		mChart.setScaleEnabled(false); //设置图表是否可缩放
		mChart.setBackgroundColor(Color.WHITE); //设置图表背景颜色
        mChart.getAxisRight().setEnabled(false); //设置右侧Y轴不可用（这里可以向得到左侧Y轴那样，得到右侧Y轴实例去处理）

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

        mLineChart.getData();   //返回这个图表中的data类型的值，
        mLineChart.getViewPortHandler();    //返回这个图表中的各种状态，返回类型为ViewPortHandler
        mLineChart.getRenderer();   //返回绘制图表的数据，类型是DataRenderer

         PointF pointF = new PointF();
                pointF = mLineChart.getCenter();   //返回中心点，返回类型是PointF，即(x,y)

 mLineChart.getCenterOffsets();  //返回图表绘制区域的中心点
        mLineChart.getYMin();  //返回 数据Y的最小值 返回值是float类型
        mLineChart.getYMax();  //返回 数据Y的最大值 返回值是float类型

 mLineChart.getLowestVisibleXIndex();  //返回 能见到的X的最小值下标 返回值是int类型
        mLineChart.getHighestVisibleXIndex();  //返回 能见到的X的最大值下标 返回值是int类型

        mLineChart.getChartBitmap();  //返回 最后状态的图表的Bitmap

         //动画效果在API版本11(Android 3.0.X)以上才能起作用，低版本不会执行，但不会崩溃
                //执行动画并不会刷新表格 即执行invalidate();方法

        ////        mLineChart.animateX(1000); //从左到右绘制图形，参数是int类型的 持续时间
        ////        mLineChart.animateY(3000); //从下到上绘制图形，参数是int类型的 持续时间
                mLineChart.animateXY(3000, 2000); //x,y同时绘制，参数是(int xDuration, int yDuration)

 mLineChart.setVisibleXRangeMaximum(5);  //一个界面显示多少个点，其他点可以通过滑动看到
        mLineChart.setVisibleXRangeMinimum(3);  //一个界面最少显示多少个点，放大后最多 放大到 剩多少 个点
//      mLineChart.setViewPortOffsets(0,0,0, 0);  //设置图表显示的偏移量，不建议使用，因为会影响图表的自动计算
        mLineChart.resetViewPortOffsets();  //重新设置图表显示的偏移量，自动计算,可取消上面的那个操作
//        mLineChart.setExtraOffsets(20, 30, 50, 10);  //设置图表外，布局内显示的偏移量

        mLineChart.fitScreen();  //重置图表的缩放，拖动并使图表符合它的界限
        mLineChart.moveViewToX(2);  //将左边的边放到指定的位置，参数是（float xindex）

        mLineChart.zoomIn();  //默认视图放大1.4倍，
        mLineChart.zoomOut();  //默认视图缩小到0.7倍，
        mLineChart.zoom(1.0f,1.0f,0f,0f);  //自定义缩放(float scaleX, float scaleY, float x, float y)X缩放倍数，Y缩放倍数，x坐标，y坐标。1f是原大小

//General Chart Styling 通用的图表造型，还有些对于特定图表有这特定方法的造型。
        //请参考https://github.com/PhilJay/MPAndroidChart/wiki/Specific-chart-settings
        lineChart.setBackgroundColor(Color.argb(0, 173, 215, 210));// 设置图表背景 参数是个Color对象

        lineChart.setDescription("setDescription我在这儿"); //图表默认右下方的描述，参数是String对象
        lineChart.setDescriptionColor(Color.rgb(227, 135, 0));  //上面字的颜色，参数是Color对象
//      lineChart.setDescriptionPosition(400f,600f);    //上面字的位置，参数是float类型，像素，从图表左上角开始计算
//      lineChart.setDescriptionTypeface();     //上面字的字体，参数是Typeface 对象
        lineChart.setDescriptionTextSize(16);    //上面字的大小，float类型[6,16]

        lineChart.setNoDataTextDescription("没有数据呢(⊙o⊙)");   //没有数据时显示在中央的字符串，参数是String对象

        lineChart.setDrawGridBackground(false);//设置图表内格子背景是否显示，默认是false
        lineChart.setGridBackgroundColor(Color.rgb(255, 0, 0));//设置格子背景色,参数是Color类型对象

        lineChart.setDrawBorders(true);     //设置图表内格子外的边框是否显示
        lineChart.setBorderColor(Color.rgb(236, 228, 126));   //上面的边框颜色
        lineChart.setBorderWidth(20);       //上面边框的宽度，float类型，dp单位
//      lineChart.setMaxVisibleValueCount();设置图表能显示的最大值，仅当setDrawValues()属性值为true时有用


   图表的交互




        lineChart.setDoubleTapToZoomEnabled(true);//设置是否可以通过双击屏幕放大图表。默认是true

        lineChart.setHighlightEnabled(false);  //If set to true, highlighting/selecting values via touch is possible for all underlying DataSets.
        lineChart.setHighlightPerDragEnabled(true);//能否拖拽高亮线(数据点与坐标的提示线)，默认是true

        lineChart.setAutoScaleMinMaxEnabled(false);


        // Chart fling / deceleration
        lineChart.setDragDecelerationEnabled(true);//拖拽滚动时，手放开是否会持续滚动，默认是true（false是拖到哪是哪，true拖拽之后还会有缓冲）
        lineChart.setDragDecelerationFrictionCoef(0.99f);//与上面那个属性配合，持续滚动时的速度快慢，[0,1) 0代表立即停止。



//如手势相关方法，选择回调方法


//        The Axis 坐标轴相关的,XY轴通用
        xAxis.setEnabled(true);     //是否显示X坐标轴 及 对应的刻度竖线，默认是true
        xAxis.setDrawAxisLine(true); //是否绘制坐标轴的线，即含有坐标的那条线，默认是true
        xAxis.setDrawGridLines(true); //是否显示X坐标轴上的刻度竖线，默认是true
        xAxis.setDrawLabels(true); //是否显示X坐标轴上的刻度，默认是true

        xAxis.setTextColor(Color.rgb(145, 13, 64)); //X轴上的刻度的颜色
        xAxis.setTextSize(5); //X轴上的刻度的字的大小 单位dp
//      xAxis.setTypeface(Typeface tf); //X轴上的刻度的字体
        xAxis.setGridColor(Color.rgb(145, 13, 64)); //X轴上的刻度竖线的颜色
        xAxis.setGridLineWidth(1); //X轴上的刻度竖线的宽 float类型
        xAxis.enableGridDashedLine(40, 3, 0); //虚线表示X轴上的刻度竖线(float lineLength, float spaceLength, float phase)三个参数，1.线长，2.虚线间距，3.虚线开始坐标




        //可以设置一条警戒线，如下：
        LimitLine ll = new LimitLine(40f, "警戒线");
        ll.setLineColor(Color.RED);
        ll.setLineWidth(4f);
        ll.setTextColor(Color.GRAY);
        ll.setTextSize(12f);
        // .. and more styling options
        xAxis.addLimitLine(ll);


//      Y轴专用
        yAxis.setStartAtZero(true);    //设置Y轴坐标是否从0开始
        yAxis.setAxisMaxValue(50);    //设置Y轴坐标最大为多少
        yAxis.resetAxisMaxValue();    //重新设置Y轴坐标最大为多少，自动调整
        yAxis.setAxisMinValue(10);    //设置Y轴坐标最小为多少
        yAxis.resetAxisMinValue();    //重新设置Y轴坐标，自动调整
        yAxis.setInverted(false);    //Y轴坐标反转,默认是false,即下小上大
        yAxis.setSpaceTop(0);    //Y轴坐标距顶有多少距离，即留白
        yAxis.setSpaceBottom(0);    //Y轴坐标距底有多少距离，即留白
        yAxis.setShowOnlyMinMax(false);    //参数如果为true Y轴坐标只显示最大值和最小值
        yAxis.setLabelCount(10, false);    //第一个参数是Y轴坐标的个数，第二个参数是 是否不均匀分布，true是不均匀分布
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);  //参数是INSIDE_CHART(Y轴坐标在内部) 或 OUTSIDE_CHART(在外部（默认是这个）)
//      yAxis.setValueFormatter(YAxisValueFormatterf);
//              Sets a custom ValueFormatter for this axis. This interface allows to format/modify
//              the original label text and instead return a customized text.

        //lineChart.setData(lineData); //添加数据



 Legend mLegend = lineChart.getLegend(); // 设置坐标线描述?? 的样式
        mLegend.setEnabled(true);
        mLegend.setTextColor(Color.rgb(255, 255, 255));// 坐标线描述文字的颜色
        mLegend.setTextSize(15);// 坐标线描述文字的大小，单位dp
//      mLegend.setTypeface(mTf);// 坐标线描述文字的字体

        mLegend.setWordWrapEnabled(true); //坐标线描述 是否 不允许出边界
        mLegend.setMaxSizePercent(0.95f);   //坐标线描述 占据的大小x%  默认0.95 即95%

        mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);//位置 RIGHT_OF_CHART, RIGHT_OF_CHART_CENTER,
        // RIGHT_OF_CHART_INSIDE, BELOW_CHART_LEFT, BELOW_CHART_RIGHT, BELOW_CHART_CENTER or PIECHART_CENTER (PieChart only), ... and more
        mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式SQUARE, CIRCLE or LINE.
        mLegend.setFormSize(10f);// 大小 单位dp

        mLegend.setXEntrySpace(20f);// 条目的水平间距
        mLegend.setYEntrySpace(20f);// 条目的垂直间距
        mLegend.setFormToTextSpace(20f);//Sets the space between the legend-label and the corresponding legend-form.

















