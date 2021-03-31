using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class AI_KK: MonoBehaviour
{
	public CharacterScript mainScript;
	
	public float[] bombSpeed;
	public float playerSpeed;
	public float[] buttonCooldowns;
	public float[] buttonLocations;
	public float playerLoc, enemyLoc;
	public int[] beltDirections = new int[8];
	public float[] bombDistance = new float[8];
	
	// Start is called once when the game runs
	void Start () {
		mainScript = GetComponent<CharacterScript>();
		
		if (mainScript == null)
		{
			print("No CharacterScript found on " + gameObject.name);
			this.enabled = false;
		}
		
		buttonLocations = mainScript.getButtonLocations();
		
		playerSpeed = mainScript.getPlayerSpeed();
	}
	
	int targetBelt = 0;
	
	public float GetBombTime (int target)
	{
		if (target < 0 || target > beltDirections.Length - 1)
			return Mathf.Infinity;
		return bombDistance[targetBelt] / bombSpeed[targetBelt];
	}
	
	// Update is called once per frame
	void Update ()
	{
		buttonCooldowns = mainScript.getButtonCooldowns();
		beltDirections = mainScript.getBeltDirections();
		
		//how fast the bombs move
		bombSpeed = mainScript.getBombSpeeds();
		
		//get locations of players
		playerLoc = mainScript.getCharacterLocation ();
		enemyLoc = mainScript.getOpponentLocation ();
		
		bombDistance = mainScript.getBombDistances ();
		
	}
}