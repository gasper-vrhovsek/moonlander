package com.dropofrational.moonlander.objects;

import com.dropofrational.moonlander.objects.ObjectFactory.BaseObject.LargeObject;
import com.dropofrational.moonlander.objects.ObjectFactory.BaseObject.SmallObject;

public class ObjectFactory {
	public static LargeObject createLargeObject(final int pX, final int pY){
		return new LargeObject(pX, pY);
	}
	
	public static SmallObject createSmallObject(final int pX, final int pY){
		return new SmallObject(pX, pY);
	}
	
	public static class BaseObject{
		private int mX;
		private int mY;
		
		public BaseObject(final int pX, final int pY) {
			this.mX = pX;
			this.mY = pY;
		}

		public static class LargeObject extends BaseObject {
			public LargeObject(int pX, int pY) {
				super(pX, pY);
			}
		}
		
		public static class SmallObject extends BaseObject {
			public SmallObject(int pX, int pY) {
				super(pX, pY);
			}
		}
	}
}
