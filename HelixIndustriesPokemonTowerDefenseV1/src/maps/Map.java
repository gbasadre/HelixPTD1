package maps;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import model.Directions;
import model.Spawner;
import model.Tile;

import Mob.Mob;

import towers.*;

public abstract class Map 
{
	int width;
	int height;
	Tile [][] grid = new Tile[height][width];
	private BufferedImage backgroundImage;
	private LinkedList<Tile> path = new LinkedList<Tile>();
	private ArrayList<Spawner> spawners = new ArrayList<Spawner>();
	private Spawner spawner;
	
	public Map() {
		
		this.grid = new Tile[width][height];
		buildGrid();
	}
	
	public void buildGrid() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = new Tile(height, width);
			}
		}
	}
	
	// Gets the grid
	public Tile [][] getGrid() {
		return grid;
	}
	
	// Gets a tile
	public Tile getTile(int row, int col) {
		return grid[row][col];
	}
	
	// Puts tower on a tile in the grid
	public abstract void setTower(int row, int col, Tower tower);
	
	// Puts mob on a tile in the grid
	public void setMob(int row, int col, Mob mob) {
		grid[row][col].setObject(mob);
	}
	
	// Sets a tile equal to the path, adds to path list, and sets Tile as prev Tile's next
	public void setPath(int row, int col) {
		path.add(grid[row][col]);
		if (path.size() > 1)
			path.get(path.size() - 1).setNextTile(grid[row][col]);
		grid[row][col].setOnPath(true);
	}
	
	public LinkedList<Tile> getPath() {
		return path;
	}
	
	// Sets direction to 0,1,2,3:
	// 0 := up
	// 1 := right
	// 2 := down
	// 3 := left
	public void setDirection(int row, int col, Directions direction) {
		grid[row][col].setDirection(direction);
	}
	
	// Set a tile to land
	public void setLand(int row, int col, boolean isLand) {
		grid[row][col].setIsLand(isLand);
	}
	
	// Set a tile to water
	public void setWater(int row, int col, boolean isWater) {
		grid[row][col].setIsLand(isWater);
	}
	
	// Fill a map with land
	public void fillLand() {
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				grid[i][j].setIsLand(true);
	}
	
	// Fill a map with water
	public void fillWater() {
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				grid[i][j].setIsWater(true);
	}
	
	// Returns tower on a tile in the grid
	public Object getObject(int row, int col) {
		return grid[row][col].getObject();
	}
	
	// Set methods for enemies, path, background, frame, more
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void addSpawners(int row, int col) {
		grid[row][col].setSpawnerTile(spawner);
		spawners.add(grid[row][col].getSpawnerTile());
	}
	
	public ArrayList<Spawner> getSpawners() {
		return spawners;
	}
	
	public abstract Image getBackground();
	
	public abstract int getGridHeight();
	public abstract int getGridWidth();

	

}
