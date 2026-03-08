package pokemon;

public class Main {
    public static void main(String args[]){
        Pokemon[] pokemonTeam = new Pokemon[6];
        pokemonTeam[0] = new FirePokemon("Charmander",5);
        pokemonTeam[1] = new WaterPokemon("Squirtle",7);
        pokemonTeam[2] = new GrassPokemon("Bulbasaur",9);
        pokemonTeam[3] = new ElectricPokemon("Pikachu",10);
        pokemonTeam[4] = new FlyingPokemon("Staraptor",7);
        pokemonTeam[5] = new FightingPokemon("Lucario",5);
        
        for(Pokemon pokemon:pokemonTeam){
            pokemon.attack();
            pokemon.displayInfo();
        }
    }
}