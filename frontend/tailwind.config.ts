import type { Config } from "tailwindcss";
import tailwind_animate from "tailwindcss-animate";
import tailwind_scrollbar from "tailwind-scrollbar";

const config : Config = {
    darkMode: ["class"],
    content: ["./index.html", "./src/**/*.{ts,tsx,js,jsx}"],
  theme: {
  	extend: {
  		borderRadius: {
  			lg: 'var(--radius)',
  			md: 'calc(var(--radius) - 2px)',
  			sm: 'calc(var(--radius) - 4px)'
  		},
  		colors: {}
  	}
  },
	plugins: [
		tailwind_animate,
		tailwind_scrollbar({
			preferredStrategy: 'pseudoelements',
			nocompatible: true
		})
	],
}

export default config;