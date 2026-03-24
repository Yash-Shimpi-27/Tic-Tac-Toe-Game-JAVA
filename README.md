# Tic Tac Toe Web Game

A modern Tic Tac Toe game built using only:

- `HTML`
- `CSS`
- `JavaScript`

No backend, no frameworks, and no build tools are required.

## Features

- Two-player local gameplay (`X` vs `O`)
- Smooth UI animations (hover, move, winner highlight)
- Clean bright white theme
- Winner and draw detection
- Reset / New Game button
- Runs fully in the browser

## Project Structure

```text
END/
├─ index.html
├─ style.css
├─ script.js
└─ README.md
```

## Run Locally

### Option 1: Directly open in browser
Open `index.html` in your browser.

### Option 2: Local server (recommended)
From project folder, run:

```bash
python -m http.server 5500
```

Then open:

[http://localhost:5500](http://localhost:5500)

## How to Play

1. Player `X` starts first.
2. Players take turns clicking empty cells.
3. First player to align 3 marks (row, column, or diagonal) wins.
4. If all cells are filled with no winner, the match is a draw.
5. Click **New Game** or **Reset Board** to start again.

## Customize

- Edit colors, shadows, and animations in `style.css`.
- Edit game logic in `script.js`.
- Edit layout/content in `index.html`.

## Deploy Online (Static Hosting)

You can host this project on any static hosting service:

- [GitHub Pages](https://pages.github.com/)
- [Netlify](https://www.netlify.com/)
- [Vercel](https://vercel.com/)
- [Cloudflare Pages](https://pages.cloudflare.com/)

Just upload the files (`index.html`, `style.css`, `script.js`) and deploy.

## License

Free to use for personal and educational projects.
