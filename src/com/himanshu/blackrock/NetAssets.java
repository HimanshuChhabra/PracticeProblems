package com.himanshu.blackrock;

import java.util.*;

public class NetAssets {

	public static void main(String[] args) {
		String s = "PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10";
		List<PortFolio> portF = new ArrayList<PortFolio>();

		String portfolios[] = s.split("\\|");

		for (String portfolio : portfolios) {
			String portDetail[] = portfolio.split(":");

			PortFolio port = new PortFolio(portDetail[0]);

			String detailedStock[] = portDetail[1].split(";");

			for (String stock : detailedStock) {
				Stock stck = new Stock();
				String stockDetail[] = stock.split(",");
				stck.setName(stockDetail[0]);
				stck.setQuantity(Integer.parseInt(stockDetail[1]));
				stck.setPrice(Integer.parseInt(stockDetail[2]));
				port.getStocks().add(stck);
			}
			portF.add(port);
		}

		PortFolio.display(PortFolio.calcDifferences(portF.get(0), portF.get(1)));
	}
}

class PortFolio {

	String name;
	double nav;
	List<Stock> stocks;
	Map<String, Double> stocksMap;

	PortFolio(String name) {
		this.name = name;
		stocks = new ArrayList<Stock>();
		stocksMap = new HashMap<String, Double>();
	}

	public String getName() {
		return name;
	}

	public double getNav() {
		return nav;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void calNav() {
		for (Stock stock : stocks) {
			nav += stock.getQuantity() * stock.getPrice();
		}
	}

	public Map<String, Double> getStocksMap() {
		return stocksMap;
	}

	public void caclPerNavPerStock() {
		for (Stock stock : stocks) {
			double perNav = ((stock.getQuantity() * stock.getPrice()) * 100) / nav;

			perNav = Double.valueOf(String.format("%.2f", perNav));

			stock.setPerNav(perNav);
			stocksMap.put(stock.getName(), perNav);
		}
	}

	public static Map<String, Double> calcDifferences(PortFolio port, PortFolio bench) {
		port.calNav();
		port.caclPerNavPerStock();

		bench.calNav();
		bench.caclPerNavPerStock();

		Map<String, Double> portstocksMap = port.getStocksMap();
		Map<String, Double> benchstocksMap = bench.getStocksMap();
		// to maintain sorted order
		Map<String, Double> resultMap = new TreeMap<String, Double>();

		for (Map.Entry<String, Double> benchMap : benchstocksMap.entrySet()) {
			if (portstocksMap.containsKey(benchMap.getKey())) {
				double benchValue = benchMap.getValue();
				double portValue = portstocksMap.get(benchMap.getKey());
				resultMap.put(benchMap.getKey(), portValue - benchValue);
			} else {
				double value = benchMap.getValue();
				resultMap.put(benchMap.getKey(), -value);
			}
		}

		for (Map.Entry<String, Double> portMap : portstocksMap.entrySet()) {
			if (!resultMap.containsKey(portMap.getKey())) {
				resultMap.put(portMap.getKey(), portMap.getValue());
			}
		}

		return resultMap;
	}

	public static void display(Map<String, Double> resultMap) {
		StringBuilder output = new StringBuilder("");
		for (Map.Entry<String, Double> result : resultMap.entrySet()) {
			output.append(result.getKey().toString() + ":" + String.format("%.2f", result.getValue()) + ",");
		}
		System.out.println(output.substring(0, output.length() - 1));
	}
}

class Stock {

	String name;
	int quantity;
	int price;
	double perNav;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getPerNav() {
		return perNav;
	}

	public void setPerNav(double perNav) {
		this.perNav = perNav;
	}

}