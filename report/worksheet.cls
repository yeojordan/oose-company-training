\ProvidesClass{worksheet}

\newcommand{\sizeOpt}{12pt}
\newcommand{\hmargin}{2.5cm}
\newcommand{\vmargin}{2.5cm}
\newcommand{\titlepadding}{1em}

\DeclareOption{cram}{\renewcommand{\hmargin}{1cm}%
                     \renewcommand{\vmargin}{2cm}%
                     \renewcommand{\titlepadding}{0em}}
\DeclareOption{10pt}{\renewcommand{\sizeOpt}{10pt}}
\DeclareOption{11pt}{\renewcommand{\sizeOpt}{11pt}}
\DeclareOption{infoonly}{\newcommand{\infoonly}{1}}
\DeclareOption*{\PassOptionsToClass{\CurrentOption}{article}}
\ProcessOptions\relax
\LoadClass[notitlepage,a4paper,\sizeOpt]{article}


% Sign-off. Must come before the "lastpage" package, and possibly others, are loaded.
\AtEndDocument{%
    \ifdefined\infoonly%
    \else%
        \par\vspace*{\stretch{1}}%
%        \centering\bf{\color{black!50}End of Report}
		\large\centering\bf{End of Report}
    \fi
}


% Essential miscellaneous packages
\usepackage{parskip}
\usepackage[normalem]{ulem}
\usepackage{xcolor}
\usepackage[colorlinks,urlcolor=blue]{hyperref}
\usepackage{tikz}
\usepackage{framed}
\usepackage[framemethod=tikz]{mdframed}
\usepackage{fancyvrb}
\usepackage{calc}

% Margins
\usepackage[hmargin=\hmargin,vmargin=\vmargin]{geometry}

% Font (Palatino-like)
% \usepackage{times}
\usepackage[T1]{fontenc}
% \usepackage[scaled=0.9]{DejaVuSans}
% \usepackage[scaled=0.9]{DejaVuSansMono}
\usepackage{inconsolata}
\usepackage[sc]{mathpazo}
\linespread{1.05}
\usepackage{textcomp}

% Commonly-used but non-essential packages
\usepackage{paralist}
\usepackage{lstautogobble}
\usepackage{listings}
% \lstset{autogobble=true,basicstyle=\footnotesize\ttfamily}
\newcommand{\texttildemid}{\raisebox{0.5ex}{\texttildelow}}
\lstset{
    autogobble=true,
    basicstyle=\ttfamily,
    basewidth=0.5em,
    frame=single,
%     escapechar=|,
%     literate={~} {\texttildemid}{1} % Middle-of-the-line tilde
}


\lstdefinestyle{pseudocode}{
    frame=single,
    language={},
    morekeywords={},
    basicstyle=\ttfamily,
    stringstyle={},
    keywordstyle={},
    identifierstyle={},
    commentstyle={}
}
\lstdefinestyle{pseudocode-small}{
    style=pseudocode,
    basicstyle=\footnotesize\ttfamily
}

\lstdefinestyle{code}{
    frame=single,
    basicstyle=\small\ttfamily\color{red},
    showstringspaces=false,
    stringstyle=\color{green!33!black},
    keywordstyle=\color{blue},
    keywordstyle=[2]\sf\bf,
    keywordstyle=[3]\sf\bf,
    keywordstyle=[4]\sf\bf,
    identifierstyle=\bfseries\color{black},
    rulecolor=\color{black},
    commentstyle=\it\tt\color{gray}
}

\lstdefinestyle{java}{
    style=code,
    language=Java,
    morekeywords={assert}
}
\lstdefinestyle{java-small}{
    style=java,
    basicstyle=\footnotesize\ttfamily\color{red},
}

\lstdefinestyle{c}{
    style=code,
    language=C
}
\lstdefinestyle{c-small}{
    style=c,
    basicstyle=\small\ttfamily\color{red},
}

\lstdefinestyle{c++}{
    style=code,
    language=C++
}

\lstdefinestyle{bash}{
    style=code,
    language=bash,
    morekeywords={elif,esac},
    morestring=[b]",
    morestring=[d]'
}

\lstdefinestyle{make}{
    style=code,
    language=make
}

\lstset{style=java}

% Setting up annotation layers (tutor notes and signoff questions_
\providecommand{\annotated}{0}
\newcommand{\annworksheet}{0}
\newcommand{\anntutornotes}{1}
\newcommand{\annsignoff}{2}
\newcommand{\fulltitle}{\@title{} \ifcase\annotated\relax\or(Tutor Notes)\or(Signoff Questions)\fi}

% Headers and footers
\usepackage{fancyhdr}
\usepackage{lastpage}
\usepackage[nodayofweek]{datetime}
\longdate
\pagestyle{fancy}
\fancyhf{}
\fancyhead[L]{\@unitname}
\fancyhead[R]{\fulltitle}
\fancyfoot[C]{\textbf{Page \thepage{} of \pageref*{LastPage}}}
%\fancyfoot[L]{\small CRICOS Provide Code: 00301J}
%\fancyfoot[R]{Page \thepage{} of \pageref*{LastPage}}

% Numbering
\renewcommand{\labelenumi}{(\alph{enumi})}
\renewcommand{\labelenumii}{(\roman{enumii})}
\newcommand{\question}[1]{\addtocounter{subsection}{1}\subsection*{\arabic{subsection}. #1}}
\newcommand{\qsection}{\setcounter{subsection}{0}\section*}

% Metadata
\newcommand{\unitname}[1]{\newcommand{\@unitname}{#1}}
\renewcommand{\title}[1]{\renewcommand{\@title}{#1}}
\renewcommand{\author}[1]{\renewcommand{\@author}{#1}}


% \renewcommand{\maketitle}{
\AtBeginDocument{
    \begin{center}
        \begin{LARGE}
            \textbf{\fulltitle}
        \end{LARGE}
    \end{center}
    \begin{flushright} Updated: \today \end{flushright}
    \vspace{\titlepadding}\par
    \ifnum\annotated>0
        \par
        \begin{large}
            {\color{red}\textbf{Do not show to students! Do not leave unattended! Return or destroy afterwards.}}
        \end{large}
        \vspace{\titlepadding}\par
    \fi
}


\newlength{\snoutermargin}
\newlength{\sninnermargin}
\newcommand{\specialnotes}[3]{%
    \ifnum\annotated>#1%
        \setlength{\snoutermargin}{-\FrameSep - \fboxrule}%
        \setlength{\sninnermargin}{\FrameSep + \fboxrule - 1mm}%
        \mdfsetup{
            leftmargin=\snoutermargin,
            rightmargin=\snoutermargin,
            innerleftmargin=\sninnermargin,
            innerrightmargin=\sninnermargin,
            skipabove=3mm,
            frametitleaboveskip=3mm,
            middlelinewidth=1mm,
            roundcorner=3mm,
            linecolor=red!50,
            frametitle={\color{red}#2}
        }%
        \begin{mdframed}#3\end{mdframed}%
    \fi%
}

\newenvironment{tutor}{%
    \VerbatimOut{\jobname.tutor}%
}{%
    \endVerbatimOut%
    \specialnotes{0}{Tutor notes}{\input{\jobname.tutor}}
}
\newcommand{\stutor}[1]{\specialnotes{0}{Tutor notes}{#1}}

\newenvironment{signoff}{%
    \VerbatimOut{\jobname.signoff}%
}{%
    \endVerbatimOut%
    \specialnotes{1}{Signoff questions}{\input{\jobname.signoff}}
}
\newcommand{\ssignoff}[1]{\specialnotes{1}{Signoff questions}{#1}}
\newcommand{\signoffquestion}[1]{\textbf{\uline{#1}} }


\newenvironment{worksheetbox}[2]{\def\FrameCommand{\fboxsep=\FrameSep \fcolorbox{#1}{#2}}\MakeFramed{\FrameRestore}}{\endMakeFramed}
\newenvironment{note}[1][Note]{\begin{worksheetbox}{green}{green!20}\textbf{#1:} }{\end{worksheetbox}}
\newenvironment{warning}[1][Warning]{\begin{worksheetbox}{red}{red!20}\textbf{#1:} }{\end{worksheetbox}}
\newenvironment{terminal}{\begin{worksheetbox}{black!50}{white}\raggedright\frenchspacing\tt}{\end{worksheetbox}}
\newenvironment{file}{\begin{terminal}}{\end{terminal}}

\newcommand{\snote}[1]{\begin{note}#1\end{note}}
\newcommand{\swarning}[1]{\begin{note}#1\end{note}}
\newcommand{\sterminal}[1]{\begin{terminal}#1\end{terminal}}
\newcommand{\sfile}[1]{\begin{file}#1\end{file}}

\newcommand{\command}[2][{[user@pc]\$}]{\par{}\texttt{{\color{black!50}#1}~#2}\par}
\newcommand{\tcommand}[2][{[user@pc]\$}]{\par{}\texttt{{\color{red!50}#1}~#2}\par}


\newcommand{\var}[1]{\uline{\sf\bf #1}}

% \newlength{\currentparskip}
% \newenvironment{minipageparskip}[2][]{%
%     \setlength{\currentparskip}{\parskip}% save the value
%     \begin{minipage}[#1]{#2}% open the minipage
%         \setlength{\parskip}{\currentparskip}% restore the value
% }{%
%     \end{minipage}%
% }

% \newcommand{\worksheetend}{\par\vspace*{\stretch{1}}\centering\bf\color{black!50}End of Worksheet\color{black}}
% \AtEndDocument{%
%         x
%     \ifdefined\infoonly%
%     \else%
%         \par\vspace*{\stretch{1}}%
%         \centering\bf{\color{black!50}End of Worksheet}
%     \fi
% }
% \AtEndDocument{def}
