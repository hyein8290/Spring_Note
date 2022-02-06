package com.test.spring.di01;

public class Lee {
	
	private Pen pen;
	
	public Lee(Pen pen) {
		this.pen = pen;
	}
	
	public void setPen(Pen pen) {
		this.pen = pen;
	}

	public void run() {
		
		//Pen을 생성한 뒤 그림을 그리기
		//Pen pen = new Pen(); //의존 객체를 직접 생성 > 사용
		
		//의존 객체를 외부로부터 공급 > 사용
		
		pen.draw();
		
	}

}
