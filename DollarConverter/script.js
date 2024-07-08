// let competition = [
//     ["Uche","Anita"],
//     ["Chizzy","Uche"],
//     ["Anita","Chizzy"]
// ];

// let result = [1, 1, 0];

let competition = [
    ["Barcelona", "Real Madrid"]
]

let result = [1];

let Home_team_won = 1;
function TournamentWinner(competition, results) {
    let Bestteam = "";
    let score = {[Bestteam] : 0};

    for(let i = 0; i < competition.length; i++){
        let result = results[i];
        let [Home, away] = competition[i];

        let WinnningTeam;
        if(result === Home_team_won){
            WinnningTeam = Home;
        } else {
            WinnningTeam = away;
        }

        updatescore(WinnningTeam, 3, score);

        if(score[WinnningTeam] > score[Bestteam]){
            Bestteam = WinnningTeam;
        }
    }
    return Bestteam;
}

function updatescore(team, point, score){
    if(!(team in score)){
        score[team] = 0;
    }
    score[team] += point;
}

console.log(TournamentWinner(competition, result));