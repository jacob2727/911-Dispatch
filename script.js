const callsSidebar = document.getElementById("calls-section");
const callsCountEl = document.getElementById("calls-counter");
const getAllCalls = async () => {
  return await fetch("calls.json").then((response) => response.json());
};

class Call {
  constructor(
    id,
    callType,
    address,
    urgency,
    respondingUnit,
    responseMinutesEta,
  ) {
    this.id = id;
    this.callType = callType;
    this.address = address;
    this.urgency = urgency;
    this.respondingUnit = respondingUnit;
    this.responseMinutesEta = responseMinutesEta;
  }
}

const displayCalls = async () => {
  const activeCalls = await getAllCalls();
  let TotalCalls = 0;

  activeCalls.forEach((e) => {
    TotalCalls++;
    const newLi = document.createElement("li");
    let arrivalStatus = "N/A";
    let cardColor = "";
    if (e.urgency == "Critical") {
      cardColor = "red";
    } else if (e.urgency == "High") {
      cardColor = "orange";
    } else {
      cardColor = "blue";
    }
    if (e.responseMinutesEta == 0) {
      arrivalStatus = "On Scene";
    } else if (!e.responseMinutesEta) {
      arrivalStatus = "Awaiting Dispatch";
    } else {
      arrivalStatus = `${e.responseMinutesEta} min away`;
    }
    newLi.className = `cursor-pointer rounded-xl border border-${cardColor}-500/30 bg-${cardColor}-500/5 p-4 transition hover:bg-${cardColor}-500/10`;
    newLi.innerHTML = `
        <div class="flex items-start justify-between gap-3">
          <div>
            <p class="font-semibold">${e.callType}</p>
            <p class="mt-1 text-xs text-zinc-500">${e.address}</p>
          </div>
          <span class="rounded bg-${cardColor}-500/15 px-2 py-1 text-xs text-${cardColor}-400">
            ${e.urgency}
          </span>
        </div>
        <div class="mt-4 flex items-center justify-between text-sm">
          <p class="text-zinc-400">${e.respondingUnit}</p>
          <p class="text-zinc-500">${arrivalStatus}</p>
        </div>
      `;

    callsSidebar.append(newLi);
  });
  callsCountEl.innerHTML = `${String(TotalCalls)} active`;
};

displayCalls();
// const activeCalls = getAllCalls().then((order) => console.log(order));

// const callElement = document.createElement("li");
// const newCall = "tetsteststhadhjsahdsahfdhfjewhf";
// callsSidebar.append(
//   (callElement.innerHTML = `${1234}tetsteststhadhjsahdsahfdhfjewhf`),
// );
