# 🎬 Nesflix

## 📘 Contexto

Se nos encomienda desarrollar el **módulo de sugerencia de películas** de la nueva aplicación de streaming **Nesflix**. La idea principal es agregar una nueva funcionalidad que permita sugerir películas de la plataforma a los usuarios registrados que ya tienen un **perfil cinéfilo definido**.

## 🧠 Perfil cinéfilo

Cada usuario registrado debe tener asociado un perfil cinéfilo, que puede cambiar cuando lo desee. Actualmente existen los siguientes perfiles (y podrían agregarse más en el futuro):

- 🎭 **Género**: El usuario define qué géneros acepta en las sugerencias. Puede elegir más de uno (por ejemplo: Comedia, Drama y Policial).
- 🆕 **Moderno**: Define a partir de qué año acepta películas. Por ejemplo, si configura 2023, solo recibirá películas estrenadas desde ese año en adelante.
- 💬 **Subtitulado**: Solo recibe sugerencias de películas que esten subtituladas.
- 🔀 **Mixto**: Puede combinar más de un perfil y acepta sugerencias si **se cumple al menos una** de las condiciones configuradas.

## 🎥 Películas

Cada película registrada en la plataforma cuenta con la siguiente información:

- 📛 Nombre
- 📅 Año de estreno
- 🧬 Género
- 🗣️ Idioma original
- 💬 Subtítulos: Lista de idiomas disponibles (por ejemplo: `['español', 'portugués']`)

Una película se considera **subtitulada** si tiene el subtitulo del idioma original porque pueden existir peliculas sin subtítulos o que dentro de los subtítulos no este el del idioma original. Por ejemplo una película con idioma original Chino Mandarín y tiene solo subtitulos en `['español', 'Ingles']`

## 👤 Usuarios

Los usuarios tienen los siguientes atributos:

- 📧 Mail
- 🎭 Perfil cinéfilo (puede cambiarlo)
- 📋 Lista de sugerencias recibidas
- 👀 Lista de películas vistas
- 🌍 Idioma definido

Además, pueden **ver una película al azar** de su lista de sugerencias.

## 💻 La Plataforma

La plataforma mantiene el registro de todos los usuarios y películas. En cualquier momento se pueden:

- ➕ Agregar o ➖ quitar películas
- ➕ Agregar o ➖ quitar usuarios

El proceso de sugerencia consiste en **evaluar cada película contra el perfil cinéfilo de cada usuario** y sugerírsela solo si corresponde.

---

## 📢 Notificar un estreno

Cada vez que una nueva película se agrega a la plataforma, esta debe **notificar automáticamente** a los distintos **canales de marketing** con los que trabaja Nesflix, para que puedan **difundir el estreno**.

Este comportamiento se debe modelar usando:

- La **Plataforma** que mantiene el registro de los canales interesados en recibir estrenos.
- Cada **Canal de Marketing** (como una radio o una revista) que se **suscribe** a la plataforma para recibir notificaciones cuando se agrega una nueva película.

### 📡 Canales de marketing actuales

- 📻 **Radio**: Al recibir la notificación de un nuevo estreno, lo **agrega automáticamente a su tanda de anuncios publicitarios**.
- 📰 **Revista**: Al recibir la notificación, **almacena la película para incluirla en su próxima edición de estrenos destacados**.

### 🔧 Requisitos adicionales

- Los canales deben poder **suscribirse o desuscribirse** en cualquier momento.
- El sistema debe estar preparado para que puedan **agregarse nuevos canales de marketing** en el futuro sin modificar la lógica principal de la plataforma.

---

## 🎁 Bonus

La dirección de la empresa solicita **agregar un nuevo perfil cinéfilo** y una **validación adicional** al momento de sugerir películas.

### 🗣️ Nuevo perfil: Nacionalista

Este perfil solo acepta sugerencias de películas cuyo **idioma original coincida exactamente** con el idioma configurado por el usuario.  
Por ejemplo, si el idioma del usuario es `español`, **solo se le sugerirán películas cuyo idioma original sea también `español`**.

### ⚠️ Nueva validación para sugerencias

A partir de ahora, al momento de sugerir una película, además de validar que **cumpla con el perfil cinéfilo del usuario**, se debe cumplir esta condición adicional:

- ❌ **No sugerir películas que el usuario ya haya visto.**
