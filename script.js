const boardEl = document.getElementById("board");
const statusEl = document.getElementById("status");
const newGameBtn = document.getElementById("newGameBtn");
const resetBtn = document.getElementById("resetBtn");

let board = Array(9).fill("");
let currentPlayer = "X";
let winner = "";
let draw = false;
let gameOver = false;
let winningCells = [];

function evaluateGame() {
  const lines = [
    [0, 1, 2], [3, 4, 5], [6, 7, 8],
    [0, 3, 6], [1, 4, 7], [2, 5, 8],
    [0, 4, 8], [2, 4, 6]
  ];

  for (const [a, b, c] of lines) {
    if (board[a] && board[a] === board[b] && board[b] === board[c]) {
      winner = board[a];
      gameOver = true;
      draw = false;
      winningCells = [a, b, c];
      return;
    }
  }

  if (board.every((cell) => cell !== "")) {
    draw = true;
    winner = "";
    gameOver = true;
    winningCells = [];
  }
}

function resetBoard() {
  board = Array(9).fill("");
  currentPlayer = "X";
  winner = "";
  draw = false;
  gameOver = false;
  winningCells = [];
  render();
}

function playMove(index) {
  if (gameOver || board[index] !== "") {
    return;
  }

  board[index] = currentPlayer;
  evaluateGame();

  if (!gameOver) {
    currentPlayer = currentPlayer === "X" ? "O" : "X";
  }
  render();
}

function render() {
  boardEl.innerHTML = "";

  board.forEach((value, index) => {
    const btn = document.createElement("button");
    btn.className = "cell";
    if (value) {
      btn.classList.add("played");
    }
    if (winningCells.includes(index)) {
      btn.classList.add("winner-cell");
    }
    btn.textContent = value;
    btn.disabled = value !== "" || gameOver;
    btn.addEventListener("click", () => playMove(index));
    boardEl.appendChild(btn);
  });

  if (winner) {
    statusEl.textContent = `Winner: ${winner}`;
    statusEl.className = "winner-text";
  } else if (draw) {
    statusEl.textContent = "It's a draw!";
    statusEl.className = "draw-text";
  } else {
    statusEl.textContent = `Current player: ${currentPlayer}`;
    statusEl.className = "";
  }
}

newGameBtn.addEventListener("click", resetBoard);
resetBtn.addEventListener("click", resetBoard);

render();
