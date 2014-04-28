package com.dropofrational.moonlander.gamemanager;

public class GameManager {

	private static GameManager INSTANCE;
	
	GameManager(){}

	private static final int INITIAL_SCORE = 0;
	private static final int INITIAL_BIRD_COUNT = 3;
	private static final int INITIAL_ENEMY_COUNT = 5;
	
	private int mCurrentScore;
	private int mBirdCount;
	private int mEnemyCount;
	
	public static GameManager getInstance(){
		if(INSTANCE == null){
			INSTANCE = new GameManager();
		}
		return INSTANCE;
	}

	public int getmCurrentScore() {
		return mCurrentScore;
	}

	public int getmBirdCount() {
		return mBirdCount;
	}
	
	public void incrementScore(int pIncrementBy){
		mCurrentScore += pIncrementBy;
	}
	
	public void decrementBirdScore(){
		mBirdCount -= 1;
	}
	
	public void resetGame(){
		mCurrentScore = INITIAL_SCORE;
		mBirdCount = INITIAL_BIRD_COUNT;
		mEnemyCount = INITIAL_ENEMY_COUNT;
	}
}
